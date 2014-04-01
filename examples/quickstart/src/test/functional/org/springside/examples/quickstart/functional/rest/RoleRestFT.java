package org.springside.examples.quickstart.functional.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.net.URI;
import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springside.examples.quickstart.data.TMRoleData;
import org.springside.examples.quickstart.entity.TMRole;
import org.springside.examples.quickstart.functional.BaseFunctionalTestCase;
import org.springside.modules.mapper.JsonMapper;
import org.springside.modules.test.category.Smoke;

/**
 * 任务管理的功能测试, 测试页面JavaScript及主要用户故事流程.
 * 
 * @author frankswu
 */
public class RoleRestFT extends BaseFunctionalTestCase {

	private final RestTemplate restTemplate = new RestTemplate();

	private final JsonMapper jsonMapper = new JsonMapper();

	private static class TMRoleList extends ArrayList<TMRole> {
	}

	private static String resoureUrl;

	@BeforeClass
	public static void initUrl() {
		resoureUrl = baseUrl + "/api/v1/role";
	}

	/**
	 * 查看任务列表.
	 */
	@Test
	@Category(Smoke.class)
	public void listTMRoles() {
		TMRoleList TMRoles = restTemplate.getForObject(resoureUrl, TMRoleList.class);
		assertEquals(5, TMRoles.size());
//		assertEquals("Study PlayFramework 2.0", TMRoles.get(0).getTitle());
	}

	/**
	 * 获取任务.
	 */
	@Test
	@Category(Smoke.class)
	public void getTMRole() {
		TMRole TMRole = restTemplate.getForObject(resoureUrl + "/{id}", TMRole.class, 1L);
//		assertEquals("Study PlayFramework 2.0", TMRole.getTitle());
	}

	/**
	 * 创建/更新/删除任务.
	 */
	@Test
	@Category(Smoke.class)
	public void createUpdateAndDeleteTMRole() {

		// create
//		TMRole TMRole = TMRoleData.randomTMRole();
		TMRole TMRole = new TMRole();

		URI TMRoleUri = restTemplate.postForLocation(resoureUrl, TMRole);
		System.out.println(TMRoleUri.toString());
		TMRole createdTMRole = restTemplate.getForObject(TMRoleUri, TMRole.class);
//		assertEquals(TMRole.getTitle(), createdTMRole.getTitle());

		// update
		String id = StringUtils.substringAfterLast(TMRoleUri.toString(), "/");
		TMRole.setId(new Long(id));
//		TMRole.setTitle(TMRoleData.randomTitle());

		restTemplate.put(TMRoleUri, TMRole);

		TMRole updatedTMRole = restTemplate.getForObject(TMRoleUri, TMRole.class);
//		assertEquals(TMRole.getTitle(), updatedTMRole.getTitle());

		// delete
		restTemplate.delete(TMRoleUri);

		try {
			restTemplate.getForObject(TMRoleUri, TMRole.class);
			fail("Get should fail while feth a deleted TMRole");
		} catch (HttpClientErrorException e) {
			assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
		}
	}

	@Test
	public void invalidCreateInput() {

		// create
		TMRole titleBlankTMRole = new TMRole();
		try {
			restTemplate.postForLocation(resoureUrl, titleBlankTMRole);
			fail("Create should fail while title is blank");
		} catch (HttpClientErrorException e) {
			assertEquals(HttpStatus.BAD_REQUEST, e.getStatusCode());
			Map messages = jsonMapper.fromJson(e.getResponseBodyAsString(), Map.class);
			assertEquals(1, messages.size());
			assertEquals("may not be empty", messages.get("title"));
		}

	}

	@Test
	public void invalidUpdateInput() {
		TMRole titleBlankTMRole = new TMRole();
		// update
		titleBlankTMRole.setId(1L);
		try {
			restTemplate.put(resoureUrl + "/1", titleBlankTMRole);
			fail("Update should fail while title is blank");
		} catch (HttpClientErrorException e) {
			assertEquals(HttpStatus.BAD_REQUEST, e.getStatusCode());
			Map messages = jsonMapper.fromJson(e.getResponseBodyAsString(), Map.class);
			assertEquals(1, messages.size());
			assertEquals("may not be empty", messages.get("title"));
		}

	}

}

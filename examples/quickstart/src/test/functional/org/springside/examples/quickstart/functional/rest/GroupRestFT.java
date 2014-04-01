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
import org.springside.examples.quickstart.data.TMGroupData;
import org.springside.examples.quickstart.entity.TMGroup;
import org.springside.examples.quickstart.functional.BaseFunctionalTestCase;
import org.springside.modules.mapper.JsonMapper;
import org.springside.modules.test.category.Smoke;

/**
 * 任务管理的功能测试, 测试页面JavaScript及主要用户故事流程.
 * 
 * @author frankswu
 */
public class GroupRestFT extends BaseFunctionalTestCase {

	private final RestTemplate restTemplate = new RestTemplate();

	private final JsonMapper jsonMapper = new JsonMapper();

	private static class TMGroupList extends ArrayList<TMGroup> {
	}

	private static String resoureUrl;

	@BeforeClass
	public static void initUrl() {
		resoureUrl = baseUrl + "/api/v1/group";
	}

	/**
	 * 查看任务列表.
	 */
	@Test
	@Category(Smoke.class)
	public void listTMGroups() {
		TMGroupList TMGroups = restTemplate.getForObject(resoureUrl, TMGroupList.class);
		assertEquals(5, TMGroups.size());
//		assertEquals("Study PlayFramework 2.0", TMGroups.get(0).getTitle());
	}

	/**
	 * 获取任务.
	 */
	@Test
	@Category(Smoke.class)
	public void getTMGroup() {
		TMGroup TMGroup = restTemplate.getForObject(resoureUrl + "/{id}", TMGroup.class, 1L);
//		assertEquals("Study PlayFramework 2.0", TMGroup.getTitle());
	}

	/**
	 * 创建/更新/删除任务.
	 */
	@Test
	@Category(Smoke.class)
	public void createUpdateAndDeleteTMGroup() {

		// create
//		TMGroup TMGroup = TMGroupData.randomTMGroup();
		TMGroup TMGroup = new TMGroup();

		URI TMGroupUri = restTemplate.postForLocation(resoureUrl, TMGroup);
		System.out.println(TMGroupUri.toString());
		TMGroup createdTMGroup = restTemplate.getForObject(TMGroupUri, TMGroup.class);
//		assertEquals(TMGroup.getTitle(), createdTMGroup.getTitle());

		// update
		String id = StringUtils.substringAfterLast(TMGroupUri.toString(), "/");
		TMGroup.setId(new Long(id));
//		TMGroup.setTitle(TMGroupData.randomTitle());

		restTemplate.put(TMGroupUri, TMGroup);

		TMGroup updatedTMGroup = restTemplate.getForObject(TMGroupUri, TMGroup.class);
//		assertEquals(TMGroup.getTitle(), updatedTMGroup.getTitle());

		// delete
		restTemplate.delete(TMGroupUri);

		try {
			restTemplate.getForObject(TMGroupUri, TMGroup.class);
			fail("Get should fail while feth a deleted TMGroup");
		} catch (HttpClientErrorException e) {
			assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
		}
	}

	@Test
	public void invalidCreateInput() {

		// create
		TMGroup titleBlankTMGroup = new TMGroup();
		try {
			restTemplate.postForLocation(resoureUrl, titleBlankTMGroup);
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
		TMGroup titleBlankTMGroup = new TMGroup();
		// update
		titleBlankTMGroup.setId(1L);
		try {
			restTemplate.put(resoureUrl + "/1", titleBlankTMGroup);
			fail("Update should fail while title is blank");
		} catch (HttpClientErrorException e) {
			assertEquals(HttpStatus.BAD_REQUEST, e.getStatusCode());
			Map messages = jsonMapper.fromJson(e.getResponseBodyAsString(), Map.class);
			assertEquals(1, messages.size());
			assertEquals("may not be empty", messages.get("title"));
		}

	}

}

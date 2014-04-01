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
import org.springside.examples.quickstart.data.TMTennisUserData;
import org.springside.examples.quickstart.entity.TMTennisUser;
import org.springside.examples.quickstart.functional.BaseFunctionalTestCase;
import org.springside.modules.mapper.JsonMapper;
import org.springside.modules.test.category.Smoke;

/**
 * 任务管理的功能测试, 测试页面JavaScript及主要用户故事流程.
 * 
 * @author frankswu
 */
public class TenniesUserRestFT extends BaseFunctionalTestCase {

	private final RestTemplate restTemplate = new RestTemplate();

	private final JsonMapper jsonMapper = new JsonMapper();

	private static class TMTennisUserList extends ArrayList<TMTennisUser> {
	}

	private static String resoureUrl;

	@BeforeClass
	public static void initUrl() {
		resoureUrl = baseUrl + "/api/v1/tenniesuser";
	}

	/**
	 * 查看任务列表.
	 */
	@Test
	@Category(Smoke.class)
	public void listTMTennisUsers() {
		TMTennisUserList TMTennisUsers = restTemplate.getForObject(resoureUrl, TMTennisUserList.class);
		assertEquals(5, TMTennisUsers.size());
//		assertEquals("Study PlayFramework 2.0", TMTennisUsers.get(0).getTitle());
	}

	/**
	 * 获取任务.
	 */
	@Test
	@Category(Smoke.class)
	public void getTMTennisUser() {
		TMTennisUser TMTennisUser = restTemplate.getForObject(resoureUrl + "/{id}", TMTennisUser.class, 1L);
//		assertEquals("Study PlayFramework 2.0", TMTennisUser.getTitle());
	}

	/**
	 * 创建/更新/删除任务.
	 */
	@Test
	@Category(Smoke.class)
	public void createUpdateAndDeleteTMTennisUser() {

		// create
//		TMTennisUser TMTennisUser = TMTennisUserData.randomTMTennisUser();
		TMTennisUser TMTennisUser = new TMTennisUser();

		URI TMTennisUserUri = restTemplate.postForLocation(resoureUrl, TMTennisUser);
		System.out.println(TMTennisUserUri.toString());
		TMTennisUser createdTMTennisUser = restTemplate.getForObject(TMTennisUserUri, TMTennisUser.class);
//		assertEquals(TMTennisUser.getTitle(), createdTMTennisUser.getTitle());

		// update
		String id = StringUtils.substringAfterLast(TMTennisUserUri.toString(), "/");
		TMTennisUser.setId(new Long(id));
//		TMTennisUser.setTitle(TMTennisUserData.randomTitle());

		restTemplate.put(TMTennisUserUri, TMTennisUser);

		TMTennisUser updatedTMTennisUser = restTemplate.getForObject(TMTennisUserUri, TMTennisUser.class);
//		assertEquals(TMTennisUser.getTitle(), updatedTMTennisUser.getTitle());

		// delete
		restTemplate.delete(TMTennisUserUri);

		try {
			restTemplate.getForObject(TMTennisUserUri, TMTennisUser.class);
			fail("Get should fail while feth a deleted TMTennisUser");
		} catch (HttpClientErrorException e) {
			assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
		}
	}

	@Test
	public void invalidCreateInput() {

		// create
		TMTennisUser titleBlankTMTennisUser = new TMTennisUser();
		try {
			restTemplate.postForLocation(resoureUrl, titleBlankTMTennisUser);
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
		TMTennisUser titleBlankTMTennisUser = new TMTennisUser();
		// update
		titleBlankTMTennisUser.setId(1L);
		try {
			restTemplate.put(resoureUrl + "/1", titleBlankTMTennisUser);
			fail("Update should fail while title is blank");
		} catch (HttpClientErrorException e) {
			assertEquals(HttpStatus.BAD_REQUEST, e.getStatusCode());
			Map messages = jsonMapper.fromJson(e.getResponseBodyAsString(), Map.class);
			assertEquals(1, messages.size());
			assertEquals("may not be empty", messages.get("title"));
		}

	}

}

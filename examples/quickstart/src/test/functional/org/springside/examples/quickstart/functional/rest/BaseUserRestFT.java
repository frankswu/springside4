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
import org.springside.examples.quickstart.data.TMBaseUserData;
import org.springside.examples.quickstart.entity.TMBaseUser;
import org.springside.examples.quickstart.functional.BaseFunctionalTestCase;
import org.springside.modules.mapper.JsonMapper;
import org.springside.modules.test.category.Smoke;

/**
 * 任务管理的功能测试, 测试页面JavaScript及主要用户故事流程.
 * 
 * @author frankswu
 */
public class BaseUserRestFT extends BaseFunctionalTestCase {

	private final RestTemplate restTemplate = new RestTemplate();

	private final JsonMapper jsonMapper = new JsonMapper();

	private static class TMBaseUserList extends ArrayList<TMBaseUser> {
	}

	private static String resoureUrl;

	@BeforeClass
	public static void initUrl() {
		resoureUrl = baseUrl + "/api/v1/baseuser";
	}

	/**
	 * 查看任务列表.
	 */
	@Test
	@Category(Smoke.class)
	public void listTMBaseUsers() {
		TMBaseUserList TMBaseUsers = restTemplate.getForObject(resoureUrl, TMBaseUserList.class);
		assertEquals(5, TMBaseUsers.size());
//		assertEquals("Study PlayFramework 2.0", TMBaseUsers.get(0).getTitle());
	}

	/**
	 * 获取任务.
	 */
	@Test
	@Category(Smoke.class)
	public void getTMBaseUser() {
		TMBaseUser TMBaseUser = restTemplate.getForObject(resoureUrl + "/{id}", TMBaseUser.class, 1L);
//		assertEquals("Study PlayFramework 2.0", TMBaseUser.getTitle());
	}

	/**
	 * 创建/更新/删除任务.
	 */
	@Test
	@Category(Smoke.class)
	public void createUpdateAndDeleteTMBaseUser() {

		// create
//		TMBaseUser TMBaseUser = TMBaseUserData.randomTMBaseUser();
		TMBaseUser TMBaseUser = new TMBaseUser();

		URI TMBaseUserUri = restTemplate.postForLocation(resoureUrl, TMBaseUser);
		System.out.println(TMBaseUserUri.toString());
		TMBaseUser createdTMBaseUser = restTemplate.getForObject(TMBaseUserUri, TMBaseUser.class);
//		assertEquals(TMBaseUser.getTitle(), createdTMBaseUser.getTitle());

		// update
		String id = StringUtils.substringAfterLast(TMBaseUserUri.toString(), "/");
		TMBaseUser.setId(new Long(id));
//		TMBaseUser.setTitle(TMBaseUserData.randomTitle());

		restTemplate.put(TMBaseUserUri, TMBaseUser);

		TMBaseUser updatedTMBaseUser = restTemplate.getForObject(TMBaseUserUri, TMBaseUser.class);
//		assertEquals(TMBaseUser.getTitle(), updatedTMBaseUser.getTitle());

		// delete
		restTemplate.delete(TMBaseUserUri);

		try {
			restTemplate.getForObject(TMBaseUserUri, TMBaseUser.class);
			fail("Get should fail while feth a deleted TMBaseUser");
		} catch (HttpClientErrorException e) {
			assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
		}
	}

	@Test
	public void invalidCreateInput() {

		// create
		TMBaseUser titleBlankTMBaseUser = new TMBaseUser();
		try {
			restTemplate.postForLocation(resoureUrl, titleBlankTMBaseUser);
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
		TMBaseUser titleBlankTMBaseUser = new TMBaseUser();
		// update
		titleBlankTMBaseUser.setId(1L);
		try {
			restTemplate.put(resoureUrl + "/1", titleBlankTMBaseUser);
			fail("Update should fail while title is blank");
		} catch (HttpClientErrorException e) {
			assertEquals(HttpStatus.BAD_REQUEST, e.getStatusCode());
			Map messages = jsonMapper.fromJson(e.getResponseBodyAsString(), Map.class);
			assertEquals(1, messages.size());
			assertEquals("may not be empty", messages.get("title"));
		}

	}

}

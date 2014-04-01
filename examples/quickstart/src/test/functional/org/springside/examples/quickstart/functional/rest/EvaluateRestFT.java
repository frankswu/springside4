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
import org.springside.examples.quickstart.data.TMEvaluateData;
import org.springside.examples.quickstart.entity.TMEvaluate;
import org.springside.examples.quickstart.functional.BaseFunctionalTestCase;
import org.springside.modules.mapper.JsonMapper;
import org.springside.modules.test.category.Smoke;

/**
 * 任务管理的功能测试, 测试页面JavaScript及主要用户故事流程.
 * 
 * @author frankswu
 */
public class EvaluateRestFT extends BaseFunctionalTestCase {

	private final RestTemplate restTemplate = new RestTemplate();

	private final JsonMapper jsonMapper = new JsonMapper();

	private static class TMEvaluateList extends ArrayList<TMEvaluate> {
	}

	private static String resoureUrl;

	@BeforeClass
	public static void initUrl() {
		resoureUrl = baseUrl + "/api/v1/evaluate";
	}

	/**
	 * 查看任务列表.
	 */
	@Test
	@Category(Smoke.class)
	public void listTMEvaluates() {
		TMEvaluateList TMEvaluates = restTemplate.getForObject(resoureUrl, TMEvaluateList.class);
		assertEquals(5, TMEvaluates.size());
//		assertEquals("Study PlayFramework 2.0", TMEvaluates.get(0).getTitle());
	}

	/**
	 * 获取任务.
	 */
	@Test
	@Category(Smoke.class)
	public void getTMEvaluate() {
		TMEvaluate TMEvaluate = restTemplate.getForObject(resoureUrl + "/{id}", TMEvaluate.class, 1L);
//		assertEquals("Study PlayFramework 2.0", TMEvaluate.getTitle());
	}

	/**
	 * 创建/更新/删除任务.
	 */
	@Test
	@Category(Smoke.class)
	public void createUpdateAndDeleteTMEvaluate() {

		// create
//		TMEvaluate TMEvaluate = TMEvaluateData.randomTMEvaluate();
		TMEvaluate TMEvaluate = new TMEvaluate();

		URI TMEvaluateUri = restTemplate.postForLocation(resoureUrl, TMEvaluate);
		System.out.println(TMEvaluateUri.toString());
		TMEvaluate createdTMEvaluate = restTemplate.getForObject(TMEvaluateUri, TMEvaluate.class);
//		assertEquals(TMEvaluate.getTitle(), createdTMEvaluate.getTitle());

		// update
		String id = StringUtils.substringAfterLast(TMEvaluateUri.toString(), "/");
		TMEvaluate.setId(new Long(id));
//		TMEvaluate.setTitle(TMEvaluateData.randomTitle());

		restTemplate.put(TMEvaluateUri, TMEvaluate);

		TMEvaluate updatedTMEvaluate = restTemplate.getForObject(TMEvaluateUri, TMEvaluate.class);
//		assertEquals(TMEvaluate.getTitle(), updatedTMEvaluate.getTitle());

		// delete
		restTemplate.delete(TMEvaluateUri);

		try {
			restTemplate.getForObject(TMEvaluateUri, TMEvaluate.class);
			fail("Get should fail while feth a deleted TMEvaluate");
		} catch (HttpClientErrorException e) {
			assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
		}
	}

	@Test
	public void invalidCreateInput() {

		// create
		TMEvaluate titleBlankTMEvaluate = new TMEvaluate();
		try {
			restTemplate.postForLocation(resoureUrl, titleBlankTMEvaluate);
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
		TMEvaluate titleBlankTMEvaluate = new TMEvaluate();
		// update
		titleBlankTMEvaluate.setId(1L);
		try {
			restTemplate.put(resoureUrl + "/1", titleBlankTMEvaluate);
			fail("Update should fail while title is blank");
		} catch (HttpClientErrorException e) {
			assertEquals(HttpStatus.BAD_REQUEST, e.getStatusCode());
			Map messages = jsonMapper.fromJson(e.getResponseBodyAsString(), Map.class);
			assertEquals(1, messages.size());
			assertEquals("may not be empty", messages.get("title"));
		}

	}

}

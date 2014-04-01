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
import org.springside.examples.quickstart.data.TMCourtData;
import org.springside.examples.quickstart.entity.TMCourt;
import org.springside.examples.quickstart.functional.BaseFunctionalTestCase;
import org.springside.modules.mapper.JsonMapper;
import org.springside.modules.test.category.Smoke;

/**
 * 任务管理的功能测试, 测试页面JavaScript及主要用户故事流程.
 * 
 * @author frankswu
 */
public class CourtRestFT extends BaseFunctionalTestCase {

	private final RestTemplate restTemplate = new RestTemplate();

	private final JsonMapper jsonMapper = new JsonMapper();

	private static class TMCourtList extends ArrayList<TMCourt> {
	}

	private static String resoureUrl;

	@BeforeClass
	public static void initUrl() {
		resoureUrl = baseUrl + "/api/v1/court";
	}

	/**
	 * 查看任务列表.
	 */
	@Test
	@Category(Smoke.class)
	public void listTMCourts() {
		TMCourtList TMCourts = restTemplate.getForObject(resoureUrl, TMCourtList.class);
		assertEquals(5, TMCourts.size());
//		assertEquals("Study PlayFramework 2.0", TMCourts.get(0).getTitle());
	}

	/**
	 * 获取任务.
	 */
	@Test
	@Category(Smoke.class)
	public void getTMCourt() {
		TMCourt TMCourt = restTemplate.getForObject(resoureUrl + "/{id}", TMCourt.class, 1L);
//		assertEquals("Study PlayFramework 2.0", TMCourt.getTitle());
	}

	/**
	 * 创建/更新/删除任务.
	 */
	@Test
	@Category(Smoke.class)
	public void createUpdateAndDeleteTMCourt() {

		// create
//		TMCourt TMCourt = TMCourtData.randomTMCourt();
		TMCourt TMCourt = new TMCourt();

		URI TMCourtUri = restTemplate.postForLocation(resoureUrl, TMCourt);
		System.out.println(TMCourtUri.toString());
		TMCourt createdTMCourt = restTemplate.getForObject(TMCourtUri, TMCourt.class);
//		assertEquals(TMCourt.getTitle(), createdTMCourt.getTitle());

		// update
		String id = StringUtils.substringAfterLast(TMCourtUri.toString(), "/");
		TMCourt.setId(new Long(id));
//		TMCourt.setTitle(TMCourtData.randomTitle());

		restTemplate.put(TMCourtUri, TMCourt);

		TMCourt updatedTMCourt = restTemplate.getForObject(TMCourtUri, TMCourt.class);
//		assertEquals(TMCourt.getTitle(), updatedTMCourt.getTitle());

		// delete
		restTemplate.delete(TMCourtUri);

		try {
			restTemplate.getForObject(TMCourtUri, TMCourt.class);
			fail("Get should fail while feth a deleted TMCourt");
		} catch (HttpClientErrorException e) {
			assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
		}
	}

	@Test
	public void invalidCreateInput() {

		// create
		TMCourt titleBlankTMCourt = new TMCourt();
		try {
			restTemplate.postForLocation(resoureUrl, titleBlankTMCourt);
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
		TMCourt titleBlankTMCourt = new TMCourt();
		// update
		titleBlankTMCourt.setId(1L);
		try {
			restTemplate.put(resoureUrl + "/1", titleBlankTMCourt);
			fail("Update should fail while title is blank");
		} catch (HttpClientErrorException e) {
			assertEquals(HttpStatus.BAD_REQUEST, e.getStatusCode());
			Map messages = jsonMapper.fromJson(e.getResponseBodyAsString(), Map.class);
			assertEquals(1, messages.size());
			assertEquals("may not be empty", messages.get("title"));
		}

	}

}

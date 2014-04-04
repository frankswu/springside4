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
import org.springside.examples.quickstart.data.TMEventData;
import org.springside.examples.quickstart.entity.TMEvent;
import org.springside.examples.quickstart.functional.BaseFunctionalTestCase;
import org.springside.modules.mapper.JsonMapper;
import org.springside.modules.test.category.Smoke;

/**
 * 任务管理的功能测试, 测试页面JavaScript及主要用户故事流程.
 * 
 * @author frankswu
 */
public class EventRestFT extends BaseFunctionalTestCase {

	private final RestTemplate restTemplate = new RestTemplate();

	private final JsonMapper jsonMapper = new JsonMapper();

	private static class TMEventList extends ArrayList<TMEvent> {
	}

	private static String resoureUrl;

	@BeforeClass
	public static void initUrl() {
		resoureUrl = baseUrl + "/api/v1/event";
	}

	/**
	 * 查看任务列表.
	 */
	@Test
	@Category(Smoke.class)
	public void listTMEvents() {
		TMEventList TMEvents = restTemplate.getForObject(resoureUrl, TMEventList.class);
		assertEquals(1, TMEvents.size());
		assertEquals("Study PlayFramework 2.0", TMEvents.get(0).getTitle());
	}

	/**
	 * 获取任务.
	 */
	@Test
	@Category(Smoke.class)
	public void getTMEvent() {
		TMEvent TMEvent = restTemplate.getForObject(resoureUrl + "/{id}", TMEvent.class, 1L);
		assertEquals("Study PlayFramework 2.0", TMEvent.getTitle());
	}

	/**
	 * 创建/更新/删除任务.
	 */
	@Test
	@Category(Smoke.class)
	public void createUpdateAndDeleteTMEvent() {

		// create
		TMEvent event = TMEventData.randomEvent();
//		TMEvent TMEvent = new TMEvent();

		URI eventUri = restTemplate.postForLocation(resoureUrl, event);
		System.out.println(eventUri.toString());
		TMEvent createdTMEvent = restTemplate.getForObject(eventUri, TMEvent.class);
		assertEquals(event.getTitle(), createdTMEvent.getTitle());

		// update
		String id = StringUtils.substringAfterLast(eventUri.toString(), "/");
		event.setId(new Long(id));
		event.setTitle(TMEventData.randomTitle());

		restTemplate.put(eventUri, event);

		TMEvent updatedEvent = restTemplate.getForObject(eventUri, TMEvent.class);
		assertEquals(event.getTitle(), updatedEvent.getTitle());

		// delete
		restTemplate.delete(eventUri);

		try {
			restTemplate.getForObject(eventUri, TMEvent.class);
			fail("Get should fail while feth a deleted TMEvent");
		} catch (HttpClientErrorException e) {
			assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
		}
	}

	@Test
	public void invalidCreateInput() {

		// create
		TMEvent titleBlankTMEvent = new TMEvent();
		try {
			restTemplate.postForLocation(resoureUrl, titleBlankTMEvent);
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
		TMEvent titleBlankTMEvent = new TMEvent();
		// update
		titleBlankTMEvent.setId(1L);
		try {
			restTemplate.put(resoureUrl + "/1", titleBlankTMEvent);
			fail("Update should fail while title is blank");
		} catch (HttpClientErrorException e) {
			assertEquals(HttpStatus.BAD_REQUEST, e.getStatusCode());
			Map messages = jsonMapper.fromJson(e.getResponseBodyAsString(), Map.class);
			assertEquals(1, messages.size());
			assertEquals("may not be empty", messages.get("title"));
		}

	}

}

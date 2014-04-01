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
import org.springside.examples.quickstart.data.TMBaseEnumData;
import org.springside.examples.quickstart.entity.TMBaseEnum;
import org.springside.examples.quickstart.functional.BaseFunctionalTestCase;
import org.springside.modules.mapper.JsonMapper;
import org.springside.modules.test.category.Smoke;

/**
 * 任务管理的功能测试, 测试页面JavaScript及主要用户故事流程.
 * 
 * @author frankswu
 */
public class BaseEnumRestFT extends BaseFunctionalTestCase {

	private final RestTemplate restTemplate = new RestTemplate();

	private final JsonMapper jsonMapper = new JsonMapper();

	private static class TMBaseEnumList extends ArrayList<TMBaseEnum> {
	}

	private static String resoureUrl;

	@BeforeClass
	public static void initUrl() {
		resoureUrl = baseUrl + "/api/v1/baseenum";
	}

	/**
	 * 查看任务列表.
	 */
	@Test
	@Category(Smoke.class)
	public void listTMBaseEnums() {
		TMBaseEnumList TMBaseEnums = restTemplate.getForObject(resoureUrl, TMBaseEnumList.class);
		assertEquals(5, TMBaseEnums.size());
//		assertEquals("Study PlayFramework 2.0", TMBaseEnums.get(0).getTitle());
	}

	/**
	 * 获取任务.
	 */
	@Test
	@Category(Smoke.class)
	public void getTMBaseEnum() {
		TMBaseEnum TMBaseEnum = restTemplate.getForObject(resoureUrl + "/{id}", TMBaseEnum.class, 1L);
//		assertEquals("Study PlayFramework 2.0", TMBaseEnum.getTitle());
	}

	/**
	 * 创建/更新/删除任务.
	 */
	@Test
	@Category(Smoke.class)
	public void createUpdateAndDeleteTMBaseEnum() {

		// create
//		TMBaseEnum TMBaseEnum = TMBaseEnumData.randomTMBaseEnum();
		TMBaseEnum TMBaseEnum = new TMBaseEnum();

		URI TMBaseEnumUri = restTemplate.postForLocation(resoureUrl, TMBaseEnum);
		System.out.println(TMBaseEnumUri.toString());
		TMBaseEnum createdTMBaseEnum = restTemplate.getForObject(TMBaseEnumUri, TMBaseEnum.class);
//		assertEquals(TMBaseEnum.getTitle(), createdTMBaseEnum.getTitle());

		// update
		String id = StringUtils.substringAfterLast(TMBaseEnumUri.toString(), "/");
		TMBaseEnum.setId(new Long(id));
//		TMBaseEnum.setTitle(TMBaseEnumData.randomTitle());

		restTemplate.put(TMBaseEnumUri, TMBaseEnum);

		TMBaseEnum updatedTMBaseEnum = restTemplate.getForObject(TMBaseEnumUri, TMBaseEnum.class);
//		assertEquals(TMBaseEnum.getTitle(), updatedTMBaseEnum.getTitle());

		// delete
		restTemplate.delete(TMBaseEnumUri);

		try {
			restTemplate.getForObject(TMBaseEnumUri, TMBaseEnum.class);
			fail("Get should fail while feth a deleted TMBaseEnum");
		} catch (HttpClientErrorException e) {
			assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
		}
	}

	@Test
	public void invalidCreateInput() {

		// create
		TMBaseEnum titleBlankTMBaseEnum = new TMBaseEnum();
		try {
			restTemplate.postForLocation(resoureUrl, titleBlankTMBaseEnum);
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
		TMBaseEnum titleBlankTMBaseEnum = new TMBaseEnum();
		// update
		titleBlankTMBaseEnum.setId(1L);
		try {
			restTemplate.put(resoureUrl + "/1", titleBlankTMBaseEnum);
			fail("Update should fail while title is blank");
		} catch (HttpClientErrorException e) {
			assertEquals(HttpStatus.BAD_REQUEST, e.getStatusCode());
			Map messages = jsonMapper.fromJson(e.getResponseBodyAsString(), Map.class);
			assertEquals(1, messages.size());
			assertEquals("may not be empty", messages.get("title"));
		}

	}

}

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
import org.springside.examples.quickstart.data.TMBaseCityData;
import org.springside.examples.quickstart.entity.TMBaseCity;
import org.springside.examples.quickstart.functional.BaseFunctionalTestCase;
import org.springside.modules.mapper.JsonMapper;
import org.springside.modules.test.category.Smoke;

/**
 * 任务管理的功能测试, 测试页面JavaScript及主要用户故事流程.
 * 
 * @author frankswu
 */
public class BaseCityRestFT extends BaseFunctionalTestCase {

	private final RestTemplate restTemplate = new RestTemplate();

	private final JsonMapper jsonMapper = new JsonMapper();

	private static class TMBaseCityList extends ArrayList<TMBaseCity> {
	}

	private static String resoureUrl;

	@BeforeClass
	public static void initUrl() {
		resoureUrl = baseUrl + "/api/v1/basecity";
	}

	/**
	 * 查看任务列表.
	 */
	@Test
	@Category(Smoke.class)
	public void listTMBaseCitys() {
		TMBaseCityList TMBaseCitys = restTemplate.getForObject(resoureUrl, TMBaseCityList.class);
		assertEquals(5, TMBaseCitys.size());
//		assertEquals("Study PlayFramework 2.0", TMBaseCitys.get(0).getTitle());
	}

	/**
	 * 获取任务.
	 */
	@Test
	@Category(Smoke.class)
	public void getTMBaseCity() {
		TMBaseCity TMBaseCity = restTemplate.getForObject(resoureUrl + "/{id}", TMBaseCity.class, 1L);
//		assertEquals("Study PlayFramework 2.0", TMBaseCity.getTitle());
	}

	/**
	 * 创建/更新/删除任务.
	 */
	@Test
	@Category(Smoke.class)
	public void createUpdateAndDeleteTMBaseCity() {

		// create
//		TMBaseCity TMBaseCity = TMBaseCityData.randomTMBaseCity();
		TMBaseCity TMBaseCity = new TMBaseCity();

		URI TMBaseCityUri = restTemplate.postForLocation(resoureUrl, TMBaseCity);
		System.out.println(TMBaseCityUri.toString());
		TMBaseCity createdTMBaseCity = restTemplate.getForObject(TMBaseCityUri, TMBaseCity.class);
//		assertEquals(TMBaseCity.getTitle(), createdTMBaseCity.getTitle());

		// update
		String id = StringUtils.substringAfterLast(TMBaseCityUri.toString(), "/");
		TMBaseCity.setId(new Long(id));
//		TMBaseCity.setTitle(TMBaseCityData.randomTitle());

		restTemplate.put(TMBaseCityUri, TMBaseCity);

		TMBaseCity updatedTMBaseCity = restTemplate.getForObject(TMBaseCityUri, TMBaseCity.class);
//		assertEquals(TMBaseCity.getTitle(), updatedTMBaseCity.getTitle());

		// delete
		restTemplate.delete(TMBaseCityUri);

		try {
			restTemplate.getForObject(TMBaseCityUri, TMBaseCity.class);
			fail("Get should fail while feth a deleted TMBaseCity");
		} catch (HttpClientErrorException e) {
			assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
		}
	}

	@Test
	public void invalidCreateInput() {

		// create
		TMBaseCity titleBlankTMBaseCity = new TMBaseCity();
		try {
			restTemplate.postForLocation(resoureUrl, titleBlankTMBaseCity);
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
		TMBaseCity titleBlankTMBaseCity = new TMBaseCity();
		// update
		titleBlankTMBaseCity.setId(1L);
		try {
			restTemplate.put(resoureUrl + "/1", titleBlankTMBaseCity);
			fail("Update should fail while title is blank");
		} catch (HttpClientErrorException e) {
			assertEquals(HttpStatus.BAD_REQUEST, e.getStatusCode());
			Map messages = jsonMapper.fromJson(e.getResponseBodyAsString(), Map.class);
			assertEquals(1, messages.size());
			assertEquals("may not be empty", messages.get("title"));
		}

	}

}

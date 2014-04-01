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
import org.springside.examples.quickstart.data.TMFileStoreData;
import org.springside.examples.quickstart.entity.TMFileStore;
import org.springside.examples.quickstart.functional.BaseFunctionalTestCase;
import org.springside.modules.mapper.JsonMapper;
import org.springside.modules.test.category.Smoke;

/**
 * 任务管理的功能测试, 测试页面JavaScript及主要用户故事流程.
 * 
 * @author frankswu
 */
public class FileStoreRestFT extends BaseFunctionalTestCase {

	private final RestTemplate restTemplate = new RestTemplate();

	private final JsonMapper jsonMapper = new JsonMapper();

	private static class TMFileStoreList extends ArrayList<TMFileStore> {
	}

	private static String resoureUrl;

	@BeforeClass
	public static void initUrl() {
		resoureUrl = baseUrl + "/api/v1/filestore";
	}

	/**
	 * 查看任务列表.
	 */
	@Test
	@Category(Smoke.class)
	public void listTMFileStores() {
		TMFileStoreList TMFileStores = restTemplate.getForObject(resoureUrl, TMFileStoreList.class);
		assertEquals(5, TMFileStores.size());
//		assertEquals("Study PlayFramework 2.0", TMFileStores.get(0).getTitle());
	}

	/**
	 * 获取任务.
	 */
	@Test
	@Category(Smoke.class)
	public void getTMFileStore() {
		TMFileStore TMFileStore = restTemplate.getForObject(resoureUrl + "/{id}", TMFileStore.class, 1L);
//		assertEquals("Study PlayFramework 2.0", TMFileStore.getTitle());
	}

	/**
	 * 创建/更新/删除任务.
	 */
	@Test
	@Category(Smoke.class)
	public void createUpdateAndDeleteTMFileStore() {

		// create
//		TMFileStore TMFileStore = TMFileStoreData.randomTMFileStore();
		TMFileStore TMFileStore = new TMFileStore();

		URI TMFileStoreUri = restTemplate.postForLocation(resoureUrl, TMFileStore);
		System.out.println(TMFileStoreUri.toString());
		TMFileStore createdTMFileStore = restTemplate.getForObject(TMFileStoreUri, TMFileStore.class);
//		assertEquals(TMFileStore.getTitle(), createdTMFileStore.getTitle());

		// update
		String id = StringUtils.substringAfterLast(TMFileStoreUri.toString(), "/");
		TMFileStore.setId(new Long(id));
//		TMFileStore.setTitle(TMFileStoreData.randomTitle());

		restTemplate.put(TMFileStoreUri, TMFileStore);

		TMFileStore updatedTMFileStore = restTemplate.getForObject(TMFileStoreUri, TMFileStore.class);
//		assertEquals(TMFileStore.getTitle(), updatedTMFileStore.getTitle());

		// delete
		restTemplate.delete(TMFileStoreUri);

		try {
			restTemplate.getForObject(TMFileStoreUri, TMFileStore.class);
			fail("Get should fail while feth a deleted TMFileStore");
		} catch (HttpClientErrorException e) {
			assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
		}
	}

	@Test
	public void invalidCreateInput() {

		// create
		TMFileStore titleBlankTMFileStore = new TMFileStore();
		try {
			restTemplate.postForLocation(resoureUrl, titleBlankTMFileStore);
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
		TMFileStore titleBlankTMFileStore = new TMFileStore();
		// update
		titleBlankTMFileStore.setId(1L);
		try {
			restTemplate.put(resoureUrl + "/1", titleBlankTMFileStore);
			fail("Update should fail while title is blank");
		} catch (HttpClientErrorException e) {
			assertEquals(HttpStatus.BAD_REQUEST, e.getStatusCode());
			Map messages = jsonMapper.fromJson(e.getResponseBodyAsString(), Map.class);
			assertEquals(1, messages.size());
			assertEquals("may not be empty", messages.get("title"));
		}

	}

}

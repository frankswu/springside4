package org.springside.examples.quickstart.data;

import org.springside.examples.quickstart.entity.TMFileStore;
import org.springside.modules.test.data.RandomData;

/**
 * FileStore相关实体测试数据生成.
 * 
 * @author calvin
 */
public class TMFileStoreData {

	public static TMFileStore randomFileStore() {
		TMFileStore FileStore = new TMFileStore();
//		FileStore.setTitle(randomTitle());
		//User user = new User(1L);
//		FileStore.setUser(user);
		return FileStore;
	}
	
	/** 文件名称 */
  	public static String randomFilename() {
		return RandomData.randomName("filename");
	}
	/** 文件url */
  	public static String randomFileurl() {
		return RandomData.randomName("fileurl");
	}
	/** 文件类型 */
  	public static String randomFiletype() {
		return RandomData.randomName("filetype");
	}


}

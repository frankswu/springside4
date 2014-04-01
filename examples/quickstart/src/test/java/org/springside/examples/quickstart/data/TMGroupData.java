package org.springside.examples.quickstart.data;

import org.springside.examples.quickstart.entity.TMGroup;
import org.springside.modules.test.data.RandomData;

/**
 * Group相关实体测试数据生成.
 * 
 * @author calvin
 */
public class TMGroupData {

	public static TMGroup randomGroup() {
		TMGroup Group = new TMGroup();
//		Group.setTitle(randomTitle());
		//User user = new User(1L);
//		Group.setUser(user);
		return Group;
	}
	
	/**  */
  	public static String randomGroupname() {
		return RandomData.randomName("groupname");
	}
	/**  */
  	public static String randomGroupdesc() {
		return RandomData.randomName("groupdesc");
	}


}

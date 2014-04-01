package org.springside.examples.quickstart.data;

import org.springside.examples.quickstart.entity.TMRole;
import org.springside.modules.test.data.RandomData;

/**
 * Role相关实体测试数据生成.
 * 
 * @author calvin
 */
public class TMRoleData {

	public static TMRole randomRole() {
		TMRole Role = new TMRole();
//		Role.setTitle(randomTitle());
		//User user = new User(1L);
//		Role.setUser(user);
		return Role;
	}
	
	/**  */
  	public static String randomRolename() {
		return RandomData.randomName("rolename");
	}
	/**  */
  	public static String randomPermissions() {
		return RandomData.randomName("permissions");
	}


}

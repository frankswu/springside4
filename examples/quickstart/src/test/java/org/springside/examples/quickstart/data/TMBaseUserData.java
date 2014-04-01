package org.springside.examples.quickstart.data;

import org.springside.examples.quickstart.entity.TMBaseUser;
import org.springside.modules.test.data.RandomData;

/**
 * BaseUser相关实体测试数据生成.
 * 
 * @author calvin
 */
public class TMBaseUserData {

	public static TMBaseUser randomBaseUser() {
		TMBaseUser BaseUser = new TMBaseUser();
//		BaseUser.setTitle(randomTitle());
		//User user = new User(1L);
//		BaseUser.setUser(user);
		return BaseUser;
	}
	
	/**  */
  	public static String randomAccount() {
		return RandomData.randomName("account");
	}
	/**  */
  	public static String randomName() {
		return RandomData.randomName("name");
	}
	/**  */
  	public static String randomPassword() {
		return RandomData.randomName("password");
	}
	/**  */
  	public static String randomRoles() {
		return RandomData.randomName("roles");
	}
	/**  */
  	public static String randomRegisterdate() {
		return RandomData.randomName("registerdate");
	}
	/**  */
  	public static String randomGrouplist() {
		return RandomData.randomName("grouplist");
	}


}

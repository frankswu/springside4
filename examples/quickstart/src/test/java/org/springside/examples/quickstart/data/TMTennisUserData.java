package org.springside.examples.quickstart.data;


import org.springside.examples.quickstart.entity.TMTennisUser;
import org.springside.modules.test.data.RandomData;

/**
 * TenniesUser相关实体测试数据生成.
 * 
 * @author calvin
 */
public class TMTennisUserData {

	public static TMTennisUser randomTenniesUser() {
		TMTennisUser TenniesUser = new TMTennisUser();
//		TenniesUser.setTitle(randomTitle());
		//User user = new User(1L);
//		TenniesUser.setUser(user);
		return TenniesUser;
	}
	
	/** 和baseuser关联一对一 */
  	public static String randomUserid() {
		return RandomData.randomName("userid");
	}
	/** 年龄 */
  	public static String randomAge() {
		return RandomData.randomName("age");
	}
	/** 地址 */
  	public static String randomAddress() {
		return RandomData.randomName("address");
	}
	/** 生日 用时间戳？（简单的使用格式化的日期字符串也可以） */
  	public static String randomBirthday() {
		return RandomData.randomName("birthday");
	}
	/** 性别 0代表男士 1代表女士 */
  	public static String randomGender() {
		return RandomData.randomName("gender");
	}
	/**  */
  	public static String randomImagelist() {
		return RandomData.randomName("imagelist");
	}
	/** 头像 */
  	public static String randomPhote() {
		return RandomData.randomName("phote");
	}
	/** 联系电话 */
  	public static String randomPhone() {
		return RandomData.randomName("phone");
	}
	/** 邮箱 */
  	public static String randomEmail() {
		return RandomData.randomName("email");
	}
	/** 球龄 */
  	public static String randomTennisage() {
		return RandomData.randomName("tennisage");
	}
	/** 水平 1.0 1.5 2.0 2.5 3.0 3.5 4.0 4.5 5.0 5.5 */
  	public static String randomTennislevel() {
		return RandomData.randomName("tennislevel");
	}
	/** 个人说明 */
  	public static String randomPersonalinfo() {
		return RandomData.randomName("personalinfo");
	}
	/** 登陆次数 */
  	public static String randomLogintimes() {
		return RandomData.randomName("logintimes");
	}
	/** 最后登陆时间 */
  	public static String randomLastlogindate() {
		return RandomData.randomName("lastlogindate");
	}
	/** 设备标识 */
  	public static String randomDeviceflag() {
		return RandomData.randomName("deviceflag");
	}
	/** 登陆状态 0 在线 1 不在线 2 黑名单 */
  	public static String randomState() {
		return RandomData.randomName("state");
	}
	/** 积分 */
  	public static String randomIntegral() {
		return RandomData.randomName("integral");
	}
	/** 等级 */
  	public static String randomAccountlevel() {
		return RandomData.randomName("accountlevel");
	}
	/** 好友印象 */
  	public static String randomFriendsimpression() {
		return RandomData.randomName("friendsimpression");
	}


}

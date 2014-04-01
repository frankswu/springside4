package org.springside.examples.quickstart.data;

import org.springside.examples.quickstart.entity.TMCourt;
import org.springside.modules.test.data.RandomData;

/**
 * Court相关实体测试数据生成.
 * 
 * @author calvin
 */
public class TMCourtData {

	public static TMCourt randomCourt() {
		TMCourt Court = new TMCourt();
//		Court.setTitle(randomTitle());
		//User user = new User(1L);
//		Court.setUser(user);
		return Court;
	}
	
	/** 场地地址 */
  	public static String randomAddress() {
		return RandomData.randomName("address");
	}
	/** 城市id */
  	public static String randomCity() {
		return RandomData.randomName("city");
	}
	/** 区县id */
  	public static String randomDistrict() {
		return RandomData.randomName("district");
	}
	/** 联系电话 */
  	public static String randomPhone() {
		return RandomData.randomName("phone");
	}
	/** 开始时间 */
  	public static String randomStarttime() {
		return RandomData.randomName("starttime");
	}
	/** 结束时间 */
  	public static String randomEndtime() {
		return RandomData.randomName("endtime");
	}
	/** 收费标准 */
  	public static String randomFee() {
		return RandomData.randomName("fee");
	}
	/** 场地情况 */
  	public static String randomCourtdesc() {
		return RandomData.randomName("courtdesc");
	}
	/** 场地片数 */
  	public static String randomCourtcount() {
		return RandomData.randomName("courtcount");
	}
	/** 评价 */
  	public static String randomEvaluates() {
		return RandomData.randomName("evaluates");
	}
	/** 图片 */
  	public static String randomImagelist() {
		return RandomData.randomName("imagelist");
	}
	/** 权重 */
  	public static String randomWeights() {
		return RandomData.randomName("weights");
	}
	/** 经度 */
  	public static String randomLongitude() {
		return RandomData.randomName("longitude");
	}
	/** 纬度 */
  	public static String randomLatitude() {
		return RandomData.randomName("latitude");
	}


}

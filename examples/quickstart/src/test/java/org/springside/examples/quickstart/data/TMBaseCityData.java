package org.springside.examples.quickstart.data;

import org.springside.examples.quickstart.entity.TMBaseCity;
import org.springside.modules.test.data.RandomData;

/**
 * BaseCity相关实体测试数据生成.
 * 
 * @author calvin
 */
public class TMBaseCityData {

	public static TMBaseCity randomBaseCity() {
		TMBaseCity BaseCity = new TMBaseCity();
//		BaseCity.setTitle(randomTitle());
		//User user = new User(1L);
//		BaseCity.setUser(user);
		return BaseCity;
	}
	
	/** 城市名称 */
  	public static String randomCityname() {
		return RandomData.randomName("cityname");
	}
	/** 城市类型 */
  	public static String randomCitytype() {
		return RandomData.randomName("citytype");
	}


}

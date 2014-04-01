package org.springside.examples.quickstart.data;

import org.springside.examples.quickstart.entity.TMBaseEnum;
import org.springside.modules.test.data.RandomData;

/**
 * BaseEnum相关实体测试数据生成.
 * 
 * @author calvin
 */
public class TMBaseEnumData {

	public static TMBaseEnum randomBaseEnum() {
		TMBaseEnum BaseEnum = new TMBaseEnum();
//		BaseEnum.setTitle(randomTitle());
		//User user = new User(1L);
//		BaseEnum.setUser(user);
		return BaseEnum;
	}
	
	/** 基础枚举类型 */
  	public static String randomEnumtype() {
		return RandomData.randomName("enumtype");
	}
	/** 枚举值 */
  	public static String randomEnumvalue() {
		return RandomData.randomName("enumvalue");
	}
	/** 枚举值描述 */
  	public static String randomEnumdesc() {
		return RandomData.randomName("enumdesc");
	}


}

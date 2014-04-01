package org.springside.examples.quickstart.data;

import org.springside.examples.quickstart.entity.TMEvaluate;
import org.springside.modules.test.data.RandomData;

/**
 * Evaluate相关实体测试数据生成.
 * 
 * @author calvin
 */
public class TMEvaluateData {

	public static TMEvaluate randomOneEvaluate() {
		TMEvaluate Evaluate = new TMEvaluate();
//		Evaluate.setTitle(randomTitle());
		//User user = new User(1L);
//		Evaluate.setUser(user);
		return Evaluate;
	}
	
	/** 评价 */
  	public static String randomEvaluate() {
		return RandomData.randomName("evaluate");
	}
	/** 评分 */
  	public static String randomScore() {
		return RandomData.randomName("score");
	}


}

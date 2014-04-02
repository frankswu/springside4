package org.springside.examples.quickstart.data;

import org.springside.examples.quickstart.entity.TMEvent;
import org.springside.modules.test.data.RandomData;

/**
 * Event相关实体测试数据生成.
 * 
 * @author calvin
 */
public class TMEventData {

	public static TMEvent randomEvent() {
		TMEvent event = new TMEvent();
        event.setTitle(randomTitle()); 
 event.setDescrition(randomDescrition()); 
// event.setOwner(randomOwner()); 
// event.setParticipant(randomParticipant()); 
 event.setPhone(randomPhone()); 
// event.setTotolPrice(randomTotolprice()); 
 event.setRequire(randomRequire()); 
// event.setComments(randomComments()); 
// event.setCommittime(randomCommittime()); 
// event.setEventtime(randomEventtime()); 
 event.setAddress(randomAddress()); 
// event.setCourt(randomCourt()); 
// event.setLongitude(randomLongitude()); 
// event.setLatitude(randomLatitude()); 
 event.setRemark(randomRemark()); 
// event.setCategory(randomCategory()); 
// event.setStatues(randomStatues()); 
// event.setWeight(randomWeight()); 
// event.setStartuserslist(randomStartuserslist()); 

		
		return event;
	}
	
	/**  */
  	public static String randomTitle() {
		return RandomData.randomName("title");
	}
	/** 内容描述 */
  	public static String randomDescrition() {
		return RandomData.randomName("descrition");
	}
	/**  // 发起者 */
  	public static String randomOwner() {
		return RandomData.randomName("owner");
	}
	/**  // 参与者 */
  	public static String randomParticipant() {
		return RandomData.randomName("participant");
	}
	/** 电话 */
  	public static String randomPhone() {
		return RandomData.randomName("phone");
	}
	/** 费用 */
  	public static String randomTotolprice() {
		return RandomData.randomName("totolprice");
	}
	/** 对手水平要求 */
  	public static String randomRequire() {
		return RandomData.randomName("require");
	}
	/** 评论 */
  	public static String randomComments() {
		return RandomData.randomName("comments");
	}
	/** 发起时间 */
  	public static String randomCommittime() {
		return RandomData.randomName("committime");
	}
	/** 活动时间 */
  	public static String randomEventtime() {
		return RandomData.randomName("eventtime");
	}
	/** 地点 */
  	public static String randomAddress() {
		return RandomData.randomName("address");
	}
	/** 场地 */
  	public static String randomCourt() {
		return RandomData.randomName("court");
	}
	/** 经度 */
  	public static String randomLongitude() {
		return RandomData.randomName("longitude");
	}
	/** 纬度 */
  	public static String randomLatitude() {
		return RandomData.randomName("latitude");
	}
	/** 备注 */
  	public static String randomRemark() {
		return RandomData.randomName("remark");
	}
	/** 分类 */
  	public static String randomCategory() {
		return RandomData.randomName("category");
	}
	/** 状态：2审核中，1未完成，0已完成 */
  	public static String randomStatues() {
		return RandomData.randomName("statues");
	}
	/** 权重 */
  	public static String randomWeight() {
		return RandomData.randomName("weight");
	}
	/** 收藏 */
  	public static String randomStartuserslist() {
		return RandomData.randomName("startuserslist");
	}


}

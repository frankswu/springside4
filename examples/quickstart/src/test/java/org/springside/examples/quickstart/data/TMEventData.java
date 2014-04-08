package org.springside.examples.quickstart.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springside.examples.quickstart.entity.TMEvent;
import org.springside.examples.quickstart.entity.TMTennisUser;
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
 event.setOwner(randomOwner()); 
// event.setParticipant(randomParticipant()); 
 event.setPhone(randomPhone()); 
 event.setTotolPrice(randomTotolprice()); 
 event.setRequire(randomRequire()); 
// event.setComments(randomComments()); 
 event.setCommitTime(new Date());
 event.setEventTime(new Date());
 event.setAddress(randomAddress()); 
// event.setCourt(randomCourt()); 
 event.setLongitude(randomLongitude()); 
 event.setLatitude(randomLatitude()); 
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
  	public static String randomDescrition() {
		return RandomData.randomName("descrition");
	}

  	public static List<TMTennisUser> randomOwner() {
		List<TMTennisUser> owners = new ArrayList<TMTennisUser>();
		TMTennisUser owner = new TMTennisUser();
		owner.setId(1L);
		owners.add(owner);
		return owners ;
	}

  	public static String randomParticipant() {
		return RandomData.randomName("participant");
	}

  	public static String randomPhone() {
		return RandomData.randomName("phone");
	}

  	public static int randomTotolprice() {
		return RandomData.randomInt();
	}

  	public static String randomRequire() {
		return RandomData.randomName("require");
	}
  	public static String randomComments() {
		return RandomData.randomName("comments");
	}

  	public static String randomCommittime() {
		return RandomData.randomDate();
	}

  	public static String randomEventtime() {
		return RandomData.randomDate();
	}

  	public static String randomAddress() {
		return RandomData.randomName("address");
	}
  	public static String randomCourt() {
		return RandomData.randomName("court");
	}

  	public static double randomLongitude() {
		return RandomData.randomDouble();
	}

  	public static double randomLatitude() {
		return RandomData.randomDouble();
	}

  	public static String randomRemark() {
		return RandomData.randomName("remark");
	}

  	public static String randomCategory() {
		return RandomData.randomName("category");
	}
  	public static String randomStatues() {
		return RandomData.randomName("statues");
	}
  	public static String randomWeight() {
		return RandomData.randomName("weight");
	}
  	public static String randomStartuserslist() {
		return RandomData.randomName("startuserslist");
	}


}

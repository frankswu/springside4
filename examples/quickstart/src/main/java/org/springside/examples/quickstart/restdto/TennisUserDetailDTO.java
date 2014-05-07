package org.springside.examples.quickstart.restdto;

import java.util.List;

import org.springside.examples.quickstart.entity.TMEvaluate;
import org.springside.examples.quickstart.entity.TMImage;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;

/**
 * @author yq_wu
 * 
 */
public class TennisUserDetailDTO extends TennisUserDTO {

	/** 邮箱 */
	private String email;
	/** 球龄 */
	private int tennisAge;
	/** 水平 1.0 1.5 2.0 2.5 3.0 3.5 4.0 4.5 5.0 5.5 */
	private int tennisLevel;
	/** 个人说明 */
	private int personalInfo;
	/** 登陆次数 */
	private int loginTimes;
	/** 最后登陆时间 */
	private String lastLoginDate;
	/** 设备标识 */
	private String deviceFlag;

	/** 好友印象 */
	private List<TMEvaluate> friendsImpression = Lists.newArrayList();
	/**  */
	private List<TMImage> imageList = Lists.newArrayList();

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTennisAge() {
		return tennisAge;
	}

	public void setTennisAge(int tennisAge) {
		this.tennisAge = tennisAge;
	}

	public int getTennisLevel() {
		return tennisLevel;
	}

	public void setTennisLevel(int tennisLevel) {
		this.tennisLevel = tennisLevel;
	}

	public int getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(int personalInfo) {
		this.personalInfo = personalInfo;
	}

	public int getLoginTimes() {
		return loginTimes;
	}

	public void setLoginTimes(int loginTimes) {
		this.loginTimes = loginTimes;
	}

	public String getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(String lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getDeviceFlag() {
		return deviceFlag;
	}

	public void setDeviceFlag(String deviceFlag) {
		this.deviceFlag = deviceFlag;
	}

	public List<TMEvaluate> getFriends_Evaluate_List() {
		return friendsImpression;
	}

	public void setFriendsImpression(List<TMEvaluate> friendsImpression) {
		this.friendsImpression = friendsImpression;
	}

	public List<TMImage> getImage_Image_List() {
		return imageList;
	}

	public void setImageList(List<TMImage> imageList) {
		this.imageList = imageList;
	}

	@JsonIgnore
	public List<TMEvaluate> getFriendsImpression() {
		return friendsImpression;
	}

	@JsonIgnore
	public List<TMImage> getImageList() {
		return imageList;
	}

}

package org.springside.examples.quickstart.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springside.examples.quickstart.restdto.TennisUserDTO;
import org.springside.modules.mapper.BeanMapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;

/**
 * @author yq_wu
 * 
 */
@Entity
@Table(name = "tb_tennis_user")
@PrimaryKeyJoinColumn(name="id")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class TMTennisUser extends TMBaseUser {

	/** 和baseuser关联一对一 */
//    private long userId;
    /** 年龄 */
    private int age;
    /** 地址 */
    private String address;
    /** 生日 用时间戳？（简单的使用格式化的日期字符串也可以） */
    private String birthday;
    /** 性别 0代表男士 1代表女士 */
    private TMBaseEnum gender;
    /** 头像 */
    private String phote;
    /** 联系电话 */
    private String phone;
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
    /** 登陆状态 0 在线 1 不在线 2 黑名单 */
    private TMBaseEnum state;
    /** 积分 */
    private String integral;
    /** 等级 */
    private String accountLevel;
    /** 好友印象 */
    private List<TMEvaluate> friendsImpression= Lists.newArrayList();
    /**  */
    private List<TMImage> images = Lists.newArrayList();
	

//	public long getUserId() {
//		return userId;
//	}
//
//	public void setUserId(long userId) {
//		this.userId = userId;
//	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	public String getPhote() {
		return phote;
	}

	public void setPhote(String phote) {
		this.phote = phote;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

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

	public String getIntegral() {
		return integral;
	}

	public void setIntegral(String integral) {
		this.integral = integral;
	}

	public String getAccountLevel() {
		return accountLevel;
	}

	public void setAccountLevel(String accountLevel) {
		this.accountLevel = accountLevel;
	}

	@NotNull
	@OneToOne
	@JoinColumn(name = "gender_id")
	public TMBaseEnum getGender() {
		return gender;
	}

	public void setGender(TMBaseEnum gender) {
		this.gender = gender;
	}

	@NotNull
	@OneToOne
	@JoinColumn(name = "state_id")
	public TMBaseEnum getState() {
		return state;
	}

	public void setState(TMBaseEnum state) {
		this.state = state;
	}
	
    /** get 好友印象 */
	@Transient
	public List<TennisUserDTO> getFriendsImpressionList() {
		List<TennisUserDTO> tennisuserDTOList = BeanMapper.mapList(friendsImpression, TennisUserDTO.class);
		return tennisuserDTOList;
	}
	
	@ManyToMany
	@JoinTable(name = "tb_user_friends", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "evaluate_id") })
	@Fetch(value = FetchMode.SUBSELECT)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JsonIgnore
	public List<TMEvaluate> getFriendsImpression() {
		return friendsImpression;
	}

	public void setFriendsImpression(List<TMEvaluate> friendsImpression) {
		this.friendsImpression = friendsImpression;
	}

    /** get 照片 */
	@Transient
	public List<TennisUserDTO> getImagesList() {
		List<TennisUserDTO> tennisuserDTOList = BeanMapper.mapList(images, TennisUserDTO.class);
		return tennisuserDTOList;
	}

	@ManyToMany
	@JoinTable(name = "tb_user_image", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "image_id") })
	@Fetch(value = FetchMode.SUBSELECT)
//	@OrderBy(clause = "id desc")
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JsonIgnore
	public List<TMImage> getImages() {
		return images;
	}

	public void setImages(List<TMImage> imageList) {
		this.images = imageList;
	}
	
	

}

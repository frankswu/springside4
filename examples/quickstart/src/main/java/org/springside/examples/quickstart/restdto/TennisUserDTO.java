package org.springside.examples.quickstart.restdto;

import org.springside.examples.quickstart.entity.TMBaseEnum;

public class TennisUserDTO {

	private long id;
	private String name;
	private String roles;
	private String registerDate;
	/** 性别 0代表男士 1代表女士 */
	private TMBaseEnum gender;
	/** 头像 */
	private String phote;
	/** 联系电话 */
	private String phone;
	/** 邮箱 */
	// private String email;
	/** 球龄 */
	// private int tennisAge;
	/** 水平 1.0 1.5 2.0 2.5 3.0 3.5 4.0 4.5 5.0 5.5 */
	// private int tennisLevel;
	/** 个人说明 */
	// private int personalInfo;
	/** 登陆次数 */
	// private int loginTimes;
	/** 最后登陆时间 */
	// private String lastLoginDate;
	/** 设备标识 */
	// private String deviceFlag;
	/** 登陆状态 0 在线 1 不在线 2 黑名单 */
	private TMBaseEnum state;
	/** 积分 */
	private String integral;
	/** 等级 */
	private String accountLevel;

	/** 好友印象 */
	// private List<TMEvaluate> friendsImpression= Lists.newArrayList();
	/**  */
	// private List<TMImage> imageList = Lists.newArrayList();
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public TMBaseEnum getGender() {
		return gender;
	}

	public void setGender(TMBaseEnum gender) {
		this.gender = gender;
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

	public TMBaseEnum getState() {
		return state;
	}

	public void setState(TMBaseEnum state) {
		this.state = state;
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

}

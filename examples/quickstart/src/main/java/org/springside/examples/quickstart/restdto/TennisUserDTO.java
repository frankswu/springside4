package org.springside.examples.quickstart.restdto;

import org.springside.examples.quickstart.entity.TMBaseEnum;
import org.springside.examples.quickstart.entity.TMTennisUser;
import org.springside.modules.mapper.BeanMapper;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class TennisUserDTO {

	private long id;
	private String account;
	private String name;
	private String roles;
	private String registerDate;
	/** 头像 */
	private String phote;
	/** 联系电话 */
	private String phone;
	/** 积分 */
	private String integral;
	/** 等级 */
	private String accountLevel;
	/** 性别 0代表男士 1代表女士 */
	private TMBaseEnum gender;
	/** 登陆状态 0 在线 1 不在线 2 黑名单 */
	private TMBaseEnum state;

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

	@JsonIgnore
	public TMBaseEnum getGender() {
		return gender;
	}

	public TMBaseEnum getGender_BaseEnum_Model() {
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

	@JsonIgnore
	public TMBaseEnum getState() {
		return state;
	}

	public TMBaseEnum getState_BaseEnum_Model() {
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

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public static TennisUserDTO createByTennisUser4List(TMTennisUser user) {
		TennisUserDTO userDTO = BeanMapper.map(user, TennisUserDTO.class);
		return userDTO;
	}

}

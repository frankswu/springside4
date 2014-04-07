package org.springside.examples.quickstart.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OrderBy;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

/**
 * 
 * 基础用户
 * 
 * @author yq_wu
 * 
 */
@Entity
@Table(name = "tb_base_user")
@Inheritance(strategy=InheritanceType.JOINED)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class TMBaseUser extends IdEntity {

	private String account;
	private String name;
	private String password;
	// private int role;// 角色 位运算 0代表普通球友 1代表教练
	private String roles;
	// private String registrationDate;// 注册时间
	private Date registerDate;

	private List<TMGroup> groupList = Lists.newArrayList();

	@NotBlank
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotBlank
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Transient
	@JsonIgnore
	public List<String> getRolesList() {
		return ImmutableList.copyOf(StringUtils.split(roles, ","));
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8:00")
	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	@ManyToMany
	@JoinTable(name = "tb_user_group", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "group_id") })
	@Fetch(value = FetchMode.SUBSELECT)
	@OrderBy(clause = " id desc ")
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public List<TMGroup> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<TMGroup> groupList) {
		this.groupList = groupList;
	}

}

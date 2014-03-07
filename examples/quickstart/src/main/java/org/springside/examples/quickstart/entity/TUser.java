package org.springside.examples.quickstart.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
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

@Entity
@Table(name = "user_tb")
public class TUser extends IdEntity {

	private String loginName;
	private String name;
	private String password;
	private String roles;
	private Date registerDate;

	private List<TGroup> groupList = Lists.newArrayList();

	@NotBlank
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
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
	@JoinTable(name = "user_group_tb", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "group_id") })
	@Fetch(value = FetchMode.SUBSELECT)
	@OrderBy(clause = " id desc ")
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public List<TGroup> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<TGroup> groupList) {
		this.groupList = groupList;
	}

}

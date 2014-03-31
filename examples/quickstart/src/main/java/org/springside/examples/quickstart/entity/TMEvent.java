package org.springside.examples.quickstart.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OrderBy;
import org.hibernate.validator.constraints.NotBlank;

import com.google.common.collect.Lists;

/**
 * 活动：标题、内容、发起者、联系方式、参与者、费用、 对手水平要求、备注、发起时间、 活动时间、<br>
 * 地点、经度、纬度、 活动评论、活动评分，活动类型、活动状态（审核中、未完成、已完成等）、 活动权重（影响排序）、收藏。
 * 
 * @author yq_wu
 * 
 */
@Entity
@Table(name = "event_tb")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class TMEvent extends IdEntity {

	private String title;// 标题
	private String descrition;// 内容描述
	// 应该是发起者的LIST<userID>
	private List<TMTennisUser> owner = Lists.newArrayList(); // 发起者
	// same as up
	private List<TMTennisUser> participant = Lists.newArrayList(); // 参与者
	private String phone;// 电话
	private double totolPrice;// 费用

	private String require;// 对手水平要求
	// 评论模型List<>
	private List<TMEvaluate> comments = Lists.newArrayList();// 评论
	private Date commitTime;// 发起时间
	private Date eventTime;// 活动时间
	private String address;// 地点
	private List<TMCourt> court = Lists.newArrayList();// 场地
	// 活动经纬度
	private double longitude;// 经度
	private double latitude;// 纬度
	private String remark;// 备注
	// 分类枚举
	private TMBaseEnum category;// 分类
	// 谁来审批？是审批什么，我个人理解是发布活动的权限
	private TMBaseEnum statues;// 状态：2审核中，1未完成，0已完成
	// 没有理解权重的意思
	private int weight;// 权重

	// TODO 收藏应该是个中间表，对应活动和人员
	private List<TMBaseUser> startUsersList = Lists.newArrayList();

	// boolean collect;// 收藏
	@NotBlank
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescrition() {
		return descrition;
	}

	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}

	@ManyToMany
	@JoinTable(name = "tb_event_owner", joinColumns = { @JoinColumn(name = "event_id") }, inverseJoinColumns = { @JoinColumn(name = "owner_id") })
	@Fetch(value = FetchMode.SUBSELECT)
	@OrderBy(clause = " id desc")
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public List<TMTennisUser> getOwner() {
		return owner;
	}

	public void setOwner(List<TMTennisUser> owner) {
		this.owner = owner;
	}

	@ManyToMany
	@JoinTable(name = "tb_event_partake", joinColumns = { @JoinColumn(name = "event_id") }, inverseJoinColumns = { @JoinColumn(name = "partake_id") })
	@Fetch(value = FetchMode.SUBSELECT)
	@OrderBy(clause = " id desc")
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public List<TMTennisUser> getParticipant() {
		return participant;
	}

	public void setParticipant(List<TMTennisUser> participant) {
		this.participant = participant;
	}

	@NotBlank
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@NotBlank
	public double getTotolPrice() {
		return totolPrice;
	}

	public void setTotolPrice(double totolPrice) {
		this.totolPrice = totolPrice;
	}

	public String getRequire() {
		return require;
	}

	public void setRequire(String require) {
		this.require = require;
	}

	@OneToMany(mappedBy = "event")
	public List<TMEvaluate> getComments() {
		return comments;
	}

	public void setComments(List<TMEvaluate> comments) {
		this.comments = comments;
	}

	public Date getCommitTime() {
		return commitTime;
	}

	public void setCommitTime(Date commitTime) {
		this.commitTime = commitTime;
	}

	@NotBlank
	public Date getEventTime() {
		return eventTime;
	}

	public void setEventTime(Date eventTime) {
		this.eventTime = eventTime;
	}

	@NotBlank
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@ManyToMany
	@JoinTable(name = "tb_event_court", joinColumns = { @JoinColumn(name = "event_id") }, inverseJoinColumns = { @JoinColumn(name = "court_id") })
	@Fetch(value = FetchMode.SUBSELECT)
	@OrderBy(clause = "id desc")
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public List<TMCourt> getCourt() {
		return court;
	}

	public void setCourt(List<TMCourt> court) {
		this.court = court;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@NotNull
	@OneToOne
	@JoinColumn(name = "category_id")
	public TMBaseEnum getCategory() {
		return category;
	}

	public void setCategory(TMBaseEnum category) {
		this.category = category;
	}

	@NotNull
	@OneToOne
	@JoinColumn(name = "event_status_id")
	public TMBaseEnum getStatues() {
		return statues;
	}

	public void setStatues(TMBaseEnum statues) {
		this.statues = statues;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@ManyToMany
	@JoinTable(name = "tb_event_startuser", joinColumns = { @JoinColumn(name = "event_id") }, inverseJoinColumns = { @JoinColumn(name = "startuser_id") })
	@Fetch(value = FetchMode.SUBSELECT)
	@OrderBy(clause = "id desc")
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public List<TMBaseUser> getStartUsersList() {
		return startUsersList;
	}

	public void setStartUsersList(List<TMBaseUser> startUsersList) {
		this.startUsersList = startUsersList;
	}

}

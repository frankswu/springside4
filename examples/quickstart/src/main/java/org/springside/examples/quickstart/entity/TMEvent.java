package org.springside.examples.quickstart.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "tb_event")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class TMEvent extends IdEntity {

	/** 标题 */
	private String title;// 标题
	/** 内容描述 */
	private String descrition;
	/** 电话 */
	private String phone;
	/** 费用 */
	private double totolPrice;
	/** 对手水平要求 */
	private String require;
	/** 发起时间 */
	private Date commitTime;
	/** 活动时间 */
	private Date eventTime;
	/** 地点 */
	private String address;
	/** 经度 */
	private double longitude;
	/** 纬度 */
	private double latitude;
	/** 备注 */
	private String remark;
	/** 分类 */
	private TMBaseEnum category;
	/** 状态：2审核中，1未完成，0已完成 */
	private TMBaseEnum statues;
	/** 权重 */
	private int weight;
	/** 收藏 */
	private List<TMBaseUser> startUsersList = Lists.newArrayList();
	/** 发起者 */
	private List<TMTennisUser> owner = Lists.newArrayList();
	/** 参与者 */
	private List<TMTennisUser> participant = Lists.newArrayList();
	/** 评论 */
	private List<TMEvaluate> comments = Lists.newArrayList();
	/** 场地 */
	private List<TMCourt> courtList = Lists.newArrayList();

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

	@ManyToMany
	@JoinTable(name = "tb_event_court", joinColumns = { @JoinColumn(name = "event_id") }, inverseJoinColumns = { @JoinColumn(name = "court_id") })
	@Fetch(value = FetchMode.SUBSELECT)
	@OrderBy(clause = "id desc")
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public List<TMCourt> getCourtList() {
		return courtList;
	}

	public void setCourtList(List<TMCourt> court) {
		this.courtList = court;
	}

	@ManyToMany
	@JoinTable(name = "tb_event_evaluate", joinColumns = { @JoinColumn(name = "event_id") }, inverseJoinColumns = { @JoinColumn(name = "evaluate_id") })
	@Fetch(value = FetchMode.SUBSELECT)
	@OrderBy(clause = "id desc")
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public List<TMEvaluate> getComments() {
		return comments;
	}

	public void setComments(List<TMEvaluate> comments) {
		this.comments = comments;
	}
}

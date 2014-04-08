package org.springside.examples.quickstart.entity;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;

/**
 * 球场
 * 
 * @author yq_wu
 * 
 */
@Entity
@Table(name = "tb_court")
public class TMCourt extends IdEntity {

    /** 场地名称 */
	private String title;
    /** 场地地址 */
    private String address;
    /** 城市id TODO 城市和区县，可以用一张表 */
    private TMBaseCity city;
    /** 区县id */
    private TMBaseCity district;
    /** 联系电话 */
    private String phone;
    /** 开始时间 */
    private String startTime;
    /** 结束时间 */
    private String endTime;
    /** 收费标准 */
    private String fee;
    /** 场地情况 */
    private String courtDesc;
    /** 场地片数 */
    private String courtCount;
    /** 权重 */
    private String weights;
    /** 经度 */
    private double longitude;
    /** 纬度 */
    private double latitude;
    /** 评价 */
    private List<TMEvaluate> evaluates = Lists.newArrayList();
    /** 图片 */
    private List<TMImage> imageList = Lists.newArrayList();

	@NotBlank
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@NotBlank
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@NotBlank
	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getCourtDesc() {
		return courtDesc;
	}

	public void setCourtDesc(String courtDesc) {
		this.courtDesc = courtDesc;
	}

	public String getCourtCount() {
		return courtCount;
	}

	public void setCourtCount(String courtCount) {
		this.courtCount = courtCount;
	}


	public String getWeights() {
		return weights;
	}

	public void setWeights(String weights) {
		this.weights = weights;
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

	@NotNull
	@OneToOne
	@JoinColumn(name = "city_id")
	public TMBaseCity getCity() {
		return city;
	}

	public void setCity(TMBaseCity city) {
		this.city = city;
	}

	@NotNull
	@OneToOne
	@JoinColumn(name = "district_id")
	public TMBaseCity getDistrict() {
		return district;
	}

	public void setDistrict(TMBaseCity district) {
		this.district = district;
	}

	@NotBlank
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@ManyToMany
	@JoinTable(name="tb_court_evaluate",joinColumns={@JoinColumn(name="court_id")},inverseJoinColumns={@JoinColumn(name="evaluate_id")})
	@Fetch(value=FetchMode.SUBSELECT)
	@OrderBy(clause="id desc")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	@JsonIgnore
	public List<TMEvaluate> getEvaluates() {
		return evaluates;
	}

	public void setEvaluates(List<TMEvaluate> evaluates) {
		this.evaluates = evaluates;
	}

	
	@ManyToMany
	@JoinTable(name="tb_court_images",joinColumns={@JoinColumn(name="court_id")},inverseJoinColumns={@JoinColumn(name="image_id")})
	@Fetch(value=FetchMode.SUBSELECT)
	@OrderBy(clause="id desc")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	@JsonIgnore
	public List<TMImage> getImageList() {
		return imageList;
	}

	public void setImageList(List<TMImage> imageList) {
		this.imageList = imageList;
	}
	
}

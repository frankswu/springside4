package org.springside.examples.quickstart.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

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

	// private String courtId;// 场地id
	private String address;// 场地地址
	// TODO 城市和区县，可以用一张表
	private TMBaseCity city;// 城市id
	private TMBaseCity district;// 区县id
	private String phone;// 联系电话 可能有多个 用|分割 eg: 18000000|1388888888
	private String startTime;// 开始时间
	private String endTime;// 结束时间
	private String fee;// 收费标准
	private String courtDesc;// 场地情况
	private String courtCount;// 场地片数
	// 应该是评价模型的列表List<Evaluate>,评分也在里面
	private List<TMEvaluate> evaluates = Lists.newArrayList();// 评价

	// private String score;// 评分
	/**
	 * TODO frankswu : 修改为多对多，图片
	 */
	private List<TMFileStore> imageList;
	// 没有理解权重的意思
	private String weights;// 权重
	private double longitude;// 经度
	private double latitude;// 纬度

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

	@OneToMany(mappedBy = "court")
	public List<TMEvaluate> getEvaluates() {
		return evaluates;
	}

	public void setEvaluates(List<TMEvaluate> evaluates) {
		this.evaluates = evaluates;
	}

	@OneToMany(mappedBy = "court")
	public List<TMFileStore> getImageList() {
		return imageList;
	}

	public void setImageList(List<TMFileStore> imageList) {
		this.imageList = imageList;
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

}

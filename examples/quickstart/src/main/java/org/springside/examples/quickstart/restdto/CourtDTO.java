package org.springside.examples.quickstart.restdto;

import org.springside.examples.quickstart.entity.TMBaseCity;
import org.springside.modules.mapper.BeanMapper;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CourtDTO {

	/**  */
	private long id;
	/** 场地地址 */
	private String address;
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
	/** 城市id */
	private TMBaseCity city;
	/** 区县id */
	private TMBaseCity district;

	/** get */
	public long getId() {
		return this.id;
	}

	/** set */
	public void setId(long id) {
		this.id = id;
	}

	/** get 场地地址 */
	public String getAddress() {
		return this.address;
	}

	/** set 场地地址 */
	public void setAddress(String address) {
		this.address = address;
	}

	/** get 联系电话 */
	public String getPhone() {
		return this.phone;
	}

	/** set 联系电话 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/** get 开始时间 */
	public String getStartTime() {
		return this.startTime;
	}

	/** set 开始时间 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/** get 结束时间 */
	public String getEndTime() {
		return this.endTime;
	}

	/** set 结束时间 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/** get 收费标准 */
	public String getFee() {
		return this.fee;
	}

	/** set 收费标准 */
	public void setFee(String fee) {
		this.fee = fee;
	}

	/** get 场地情况 */
	public String getCourtDesc() {
		return this.courtDesc;
	}

	/** set 场地情况 */
	public void setCourtDesc(String courtDesc) {
		this.courtDesc = courtDesc;
	}

	/** get 场地片数 */
	public String getCourtCount() {
		return this.courtCount;
	}

	/** set 场地片数 */
	public void setCourtCount(String courtCount) {
		this.courtCount = courtCount;
	}

	/** get 权重 */
	public String getWeights() {
		return this.weights;
	}

	/** set 权重 */
	public void setWeights(String weights) {
		this.weights = weights;
	}

	/** get 经度 */
	public double getLongitude() {
		return this.longitude;
	}

	/** set 经度 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/** get 纬度 */
	public double getLatitude() {
		return this.latitude;
	}

	/** set 纬度 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	@JsonIgnore
	public Long getCityModelId() {
		return this.city.getId();
	}

	@JsonIgnore
	public BaseCityDTO getCityModelDTO() {
		return BeanMapper.map(this.city, BaseCityDTO.class);
	}

	/** get 城市id */
	public TMBaseCity getCity() {
		return this.city;
	}

	/** set 城市id */
	public void setCity(TMBaseCity cityModel) {
		this.city = cityModel;
	}

	@JsonIgnore
	public Long getDistrictModelId() {
		return this.district.getId();
	}

	@JsonIgnore
	public BaseCityDTO getDistrictModelDTO() {
		return BeanMapper.map(this.district, BaseCityDTO.class);
	}

	/** get 区县id */
	public TMBaseCity getDistrict() {
		return this.district;
	}

	/** set 区县id */
	public void setDistrict(TMBaseCity districtModel) {
		this.district = districtModel;
	}

}

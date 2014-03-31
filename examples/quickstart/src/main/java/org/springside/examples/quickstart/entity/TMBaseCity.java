package org.springside.examples.quickstart.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 基础城市或地址
 * 
 * @author yq_wu
 * 
 */
@Entity
@Table(name = "tb_base_city")
public class TMBaseCity extends IdEntity {
	/** 城市名称 */
	private String cityName;
	/** 城市类型 */
	private String cityType;

	@NotBlank
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@NotBlank
	public String getCityType() {
		return cityType;
	}

	public void setCityType(String cityType) {
		this.cityType = cityType;
	}

}

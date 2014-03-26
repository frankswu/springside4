package org.springside.examples.quickstart.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 基础枚举数据表
 * 
 * @author yq_wu
 * 
 */
@Entity
@Table(name="base_enum_tb")
public class TMBaseEnum extends IdEntity {

	private String enumType;// 基础枚举类型
	private String enumValue;// 枚举值
	private String enumDesc;// 枚举值描述
	
	@NotBlank
	public String getEnumType() {
		return enumType;
	}
	public void setEnumType(String enumType) {
		this.enumType = enumType;
	}
	@NotBlank
	public String getEnumValue() {
		return enumValue;
	}
	public void setEnumValue(String enumValue) {
		this.enumValue = enumValue;
	}
	@NotBlank
	public String getEnumDesc() {
		return enumDesc;
	}
	public void setEnumDesc(String enumDesc) {
		this.enumDesc = enumDesc;
	}
	
	
	
}

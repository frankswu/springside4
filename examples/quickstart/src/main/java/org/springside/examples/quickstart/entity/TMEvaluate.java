package org.springside.examples.quickstart.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 评价model
 * 
 * @author yq_wu
 * 
 */
@Entity
@Table(name = "tb_evaluate")
public class TMEvaluate extends IdEntity {

	private String evaluate;// 评价
	private double score;// 评分

	/** 评论分类 */
	private TMBaseEnum evaluateCategory;

	@NotBlank
	public String getEvaluate() {
		return evaluate;
	}

	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}

	@NotBlank
	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@NotNull
	@OneToOne
	@JoinColumn(name = "category_id")
	@JsonIgnore
	public TMBaseEnum getEvaluateCategory() {
		return evaluateCategory;
	}

	@Transient
	public String getCategory() {
		return evaluateCategory.getEnumValue();
	}

	public void setCategory(String categroy) {
		// return evaluateCategory.getEnumValue();
	}

	public void setEvaluateCategory(TMBaseEnum evaluateCategory) {
		this.evaluateCategory = evaluateCategory;
	}

}

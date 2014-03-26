package org.springside.examples.quickstart.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 评价model
 * 
 * @author yq_wu
 * 
 */
@Entity
@Table(name = "evaluate_tb")
public class TMEvaluate extends IdEntity {

	private String evaluate;// 评价
	private double score;// 评分
	/**
	 * 评论分类
	 */
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
	@NotBlank
	public TMBaseEnum getEvaluateCategory() {
		return evaluateCategory;
	}
	public void setEvaluateCategory(TMBaseEnum evaluateCategory) {
		this.evaluateCategory = evaluateCategory;
	}

	
	
}

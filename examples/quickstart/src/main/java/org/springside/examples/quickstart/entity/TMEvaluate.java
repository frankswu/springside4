package org.springside.examples.quickstart.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

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

	/**
	 * TODO frankswu : 重构为多对多，场地
	 */
	private TMCourt court;
	/**
	 * TODO frankswu : 重构为多对多，活动
	 */
	private TMEvent event;
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

	@NotNull
	@OneToOne
	@JoinColumn(name = "category_id")
	public TMBaseEnum getEvaluateCategory() {
		return evaluateCategory;
	}

	public void setEvaluateCategory(TMBaseEnum evaluateCategory) {
		this.evaluateCategory = evaluateCategory;
	}

	@ManyToOne
	@JoinColumn(name = "court_id")
	public TMCourt getCourt() {
		return court;
	}

	public void setCourt(TMCourt court) {
		this.court = court;
	}

	@ManyToOne
	@JoinColumn(name = "event_id")
	public TMEvent getEvent() {
		return event;
	}

	public void setEvent(TMEvent event) {
		this.event = event;
	}

}

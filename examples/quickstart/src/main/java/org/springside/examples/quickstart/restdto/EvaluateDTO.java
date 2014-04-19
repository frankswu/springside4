package org.springside.examples.quickstart.restdto;

import org.springside.examples.quickstart.entity.TMBaseEnum;
import org.springside.modules.mapper.BeanMapper;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class EvaluateDTO {

	/**  */
	private long id;
	/** 评价 */
	private String evaluate;
	/** 评分 */
	private double score;
	/** 评论分类 */
	private TMBaseEnum evaluateCategory;

	/** get */
	public long getId() {
		return this.id;
	}

	/** set */
	public void setId(long id) {
		this.id = id;
	}

	/** get 评价 */
	public String getEvaluate() {
		return this.evaluate;
	}

	/** set 评价 */
	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}

	/** get 评分 */
	public double getScore() {
		return this.score;
	}

	/** set 评分 */
	public void setScore(double score) {
		this.score = score;
	}

	@JsonIgnore
	public Long getCategoryModelId() {
		return this.evaluateCategory.getId();
	}

	@JsonIgnore
	public BaseEnumDTO getCategoryModelDTO() {
		return BeanMapper.map(this.evaluateCategory, BaseEnumDTO.class);
	}

	/** get 评论分类 */
	public TMBaseEnum getCategory() {
		return this.evaluateCategory;
	}

	@JsonIgnore
	public TMBaseEnum getEvaluateCategory() {
		return evaluateCategory;
	}

	/** set 评论分类 */
	public void setEvaluateCategory(TMBaseEnum categoryModel) {
		this.evaluateCategory = categoryModel;
	}

}

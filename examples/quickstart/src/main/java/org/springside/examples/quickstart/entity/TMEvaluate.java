package org.springside.examples.quickstart.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

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
	private int score;// 评分

}

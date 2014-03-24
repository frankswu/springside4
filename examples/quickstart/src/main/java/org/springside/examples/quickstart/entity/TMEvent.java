package org.springside.examples.quickstart.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 活动：标题、内容、发起者、联系方式、参与者、费用、 对手水平要求、备注、发起时间、 活动时间、<br>
 * 地点、经度、纬度、 活动评论、活动评分，活动类型、活动状态（审核中、未完成、已完成等）、 活动权重（影响排序）、收藏。
 * 
 * @author yq_wu
 * 
 */
@Entity
@Table(name = "event_tb")
public class TMEvent extends IdEntity {

	private String title;// 标题
	private String descrition;// 内容描述
	// 应该是发起者的LIST<userID>
	private String owner; // 发起者
	// same as up
	private List<String> participant; // 参与者
	private String phone;// 电话
	private double totolPrice;// 费用

	private String require;// 对手水平要求
	// 评论模型List<>
	private List<TMEvaluate> comments;// 评论
	private Date commitTime;// 发起时间
	private Date eventTime;// 活动时间
	// 应该是场地id，经纬度应该是在场地里面的
	private String address;// 地点
	private double longitude;// 经度
	private double latitude;// 纬度
	private String remark;// 备注
	// h活动的评分还是场地的评分？
	// private double score;// 评分
	// 分类是什么意思
	private String category;// 分类
	// 谁来审批？是审批什么，我个人理解是发布活动的权限
	private int statues;// 状态：2审核中，1未完成，0已完成
	// 没有理解权重的意思
	private int weight;// 权重
	// TODO 收藏应该是个中间表，对应活动和人员
	boolean collect;// 收藏

}

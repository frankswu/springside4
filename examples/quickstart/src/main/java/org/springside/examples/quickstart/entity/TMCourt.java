package org.springside.examples.quickstart.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 球场
 * 
 * @author yq_wu
 * 
 */
@Entity
@Table(name = "court_tb")
public class TMCourt extends IdEntity {

	// private String courtId;// 场地id
	private String address;// 场地地址
	private String cityId;// 城市id
	private String districtId;// 区县id
	private String phone;// 联系电话 可能有多个 用|分割 eg: 18000000|1388888888
	private String startTime;// 开始时间
	private String endTime;// 结束时间
	private String fee;// 收费标准
	private String courtDesc;// 场地情况
	private String courtCount;// 场地片数
	// 应该是评价模型的列表List<Evaluate>,评分也在里面
	private List<TMEvaluate> evaluates;// 评价
	// private String score;// 评分
	/**
	 * 图片
	 */
	private List<TMFileStore> imageList;
	// 没有理解权重的意思
	private String weights;// 权重
	private double longitude;// 经度
	private double latitude;// 纬度

}

package org.springside.examples.quickstart.restdto;

import java.util.List;

import org.springside.examples.quickstart.entity.TMBaseEnum;
import org.springside.examples.quickstart.entity.TMCourt;
import org.springside.examples.quickstart.entity.TMEvaluate;
import org.springside.examples.quickstart.entity.TMEvent;
import org.springside.examples.quickstart.entity.TMTennisUser;
import org.springside.modules.mapper.BeanMapper;
import org.springside.modules.utils.Collections3;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class EventDTO {

	/**  */
	protected long id;
	/** 标题 */
	protected String title;
	/** 内容描述 */
	protected String descrition;
	/** 电话 */
	protected String phone;
	/** 费用 */
	protected double totolPrice;
	/** 对手水平要求 */
	protected String require;
	/** 发起时间 */
	protected String commitTime;
	/** 活动时间 */
	protected String eventTime;
	/** 地点 */
	protected String address;
	/** 经度 */
	protected double longitude;
	/** 纬度 */
	protected double latitude;
	/** 备注 */
	protected String remark;
	/** 权重 */
	protected int weight;
	/** 分类 */
	protected TMBaseEnum category;
	/** 状态：2审核中，1未完成，0已完成 */
	protected TMBaseEnum statues;
	/** 收藏 */
	protected List<TMTennisUser> startUsersModelList;
	/** // 发起者 */
	protected List<TMTennisUser> ownersModelList;
	/** // 参与者 */
	protected List<TMTennisUser> participantModelList;
	/** 评论 */
	protected List<TMEvaluate> commentsModelList;
	/** 场地 */
	protected List<TMCourt> courtsModelList;

	/** get */
	public long getId() {
		return this.id;
	}

	/** set */
	public void setId(long id) {
		this.id = id;
	}

	/** get 标题 */
	public String getTitle() {
		return this.title;
	}

	/** set 标题 */
	public void setTitle(String title) {
		this.title = title;
	}

	/** get 内容描述 */
	public String getDescrition() {
		return this.descrition;
	}

	/** set 内容描述 */
	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}

	/** get 电话 */
	public String getPhone() {
		return this.phone;
	}

	/** set 电话 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/** get 费用 */
	public double getTotolPrice() {
		return this.totolPrice;
	}

	/** set 费用 */
	public void setTotolPrice(double totolPrice) {
		this.totolPrice = totolPrice;
	}

	/** get 对手水平要求 */
	public String getRequire() {
		return this.require;
	}

	/** set 对手水平要求 */
	public void setRequire(String require) {
		this.require = require;
	}

	/** get 发起时间 */
	public String getCommitTime() {
		return this.commitTime;
	}

	/** set 发起时间 */
	public void setCommitTime(String commitTime) {
		this.commitTime = commitTime;
	}

	/** get 活动时间 */
	public String getEventTime() {
		return this.eventTime;
	}

	/** set 活动时间 */
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	/** get 地点 */
	public String getAddress() {
		return this.address;
	}

	/** set 地点 */
	public void setAddress(String address) {
		this.address = address;
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

	/** get 备注 */
	public String getRemark() {
		return this.remark;
	}

	/** set 备注 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/** get 权重 */
	public int getWeight() {
		return this.weight;
	}

	/** set 权重 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	@JsonIgnore
	public Long getCategoryModelId() {
		return this.category.getId();
	}

	@JsonIgnore
	public BaseEnumDTO getCategoryModelDTO() {
		return BeanMapper.map(this.category, BaseEnumDTO.class);
	}

	/** get 分类 */
	@JsonIgnore
	public TMBaseEnum getCategory() {
		return this.category;
	}

	/** get 分类 */
	public TMBaseEnum getCategory_BaseEnum_Model() {
		return this.category;
	}

	/** set 分类 */
	public void setCategory(TMBaseEnum categoryModel) {
		this.category = categoryModel;
	}

	@JsonIgnore
	public Long getStatuesModelId() {
		return this.statues.getId();
	}

	@JsonIgnore
	public BaseEnumDTO getStatuesModelDTO() {
		return BeanMapper.map(this.statues, BaseEnumDTO.class);
	}

	/** get 状态：2审核中，1未完成，0已完成 */
	@JsonIgnore
	public TMBaseEnum getStatues() {
		return this.statues;
	}

	/** get 状态：2审核中，1未完成，0已完成 */
	public TMBaseEnum getStatues_BaseEnum_Model() {
		return this.statues;
	}

	/** set 状态：2审核中，1未完成，0已完成 */
	public void setStatues(TMBaseEnum statuesModel) {
		this.statues = statuesModel;
	}

	@JsonIgnore
	public List<Long> getStartUsersModelListIds() {
		return Collections3.extractToList(this.startUsersModelList, "id");
		// return BeanMapper.mapList(this.startUsersModelList,Long.class);
	}

	public List<TennisUserDTO> getStartUsers_TennisUser_List() {
		return BeanMapper.mapList(this.startUsersModelList, TennisUserDTO.class);
	}

	/** get 收藏 */
	@JsonIgnore
	public List<TMTennisUser> getStartUsersModelList() {
		return this.startUsersModelList;
	}

	/** set 收藏 */
	public void setStartUsersModelList(List<TMTennisUser> startUsersModelList) {
		this.startUsersModelList = startUsersModelList;
	}

	@JsonIgnore
	public List<Long> getOwnersModelListIds() {
		return Collections3.extractToList(this.ownersModelList, "id");
	}

	public List<TennisUserDTO> getOwners_TennisUser_List() {
		return BeanMapper.mapList(this.ownersModelList, TennisUserDTO.class);
	}

	/** get // 发起者 */
	@JsonIgnore
	public List<TMTennisUser> getOwnersModelList() {
		return this.ownersModelList;
	}

	/** set // 发起者 */
	public void setOwnersModelList(List<TMTennisUser> ownersModelList) {
		this.ownersModelList = ownersModelList;
	}

	@JsonIgnore
	public List<Long> getParticipantModelListIds() {
		return Collections3.extractToList(this.participantModelList, "id");
	}

	public List<TennisUserDTO> getParticipant_TennisUser_List() {
		return BeanMapper.mapList(this.participantModelList, TennisUserDTO.class);
	}

	/** get // 参与者 */
	@JsonIgnore
	public List<TMTennisUser> getParticipantModelList() {
		return this.participantModelList;
	}

	/** set // 参与者 */
	public void setParticipantModelList(List<TMTennisUser> participantModelList) {
		this.participantModelList = participantModelList;
	}

	@JsonIgnore
	public List<Long> getEvaluatesModelListIds() {
		return Collections3.extractToList(this.commentsModelList, "id");
	}

	public List<EvaluateDTO> getComments_Evaluate_List() {
		return BeanMapper.mapList(this.commentsModelList, EvaluateDTO.class);
	}

	/** get 评论 */
	@JsonIgnore
	public List<TMEvaluate> getEvaluatesModelList() {
		return this.commentsModelList;
	}

	/** set 评论 */
	public void setEvaluatesModelList(List<TMEvaluate> evaluatesModelList) {
		this.commentsModelList = evaluatesModelList;
	}

	@JsonIgnore
	public List<Long> getCourtsModelListIds() {
		return Collections3.extractToList(this.courtsModelList, "id");
	}

	public List<CourtDTO> getCourts_Court_List() {
		return BeanMapper.mapList(this.courtsModelList, CourtDTO.class);
	}

	/** get 场地 */
	@JsonIgnore
	public List<TMCourt> getCourtsModelList() {
		return this.courtsModelList;
	}

	/** set 场地 */
	public void setCourtsModelList(List<TMCourt> courtsModelList) {
		this.courtsModelList = courtsModelList;
	}

	public static EventDTO createByEvent4List(TMEvent event) {

		EventDTO dto = BeanMapper.map(event, EventDTO.class);
		dto.setStartUsersModelList(event.getStartUsers());
		dto.setOwnersModelList(event.getOwner());
		dto.setParticipantModelList(event.getParticipant());
		dto.setCourtsModelList(event.getCourtList());
		dto.setEvaluatesModelList(event.getComments());
		return dto;
	}

}

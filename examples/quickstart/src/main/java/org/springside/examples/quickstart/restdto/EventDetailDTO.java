package org.springside.examples.quickstart.restdto;

import java.util.ArrayList;
import java.util.List;

import org.springside.examples.quickstart.entity.TMCourt;
import org.springside.examples.quickstart.entity.TMEvaluate;
import org.springside.examples.quickstart.entity.TMEvent;
import org.springside.examples.quickstart.entity.TMTennisUser;
import org.springside.modules.mapper.BeanMapper;

/**
 * @author yq_wu
 * 
 */
public class EventDetailDTO extends EventDTO {

	// @JsonIgnore
	// public List<Long> getStartUsersModelListIds() {
	// return Collections3.extractToList(this.startUsersModelList, "id");
	// // return BeanMapper.mapList(this.startUsersModelList,Long.class);
	// }

	public List<TennisUserDTO> getStartUsers_TennisUser_List() {
		List<TennisUserDTO> user = new ArrayList<TennisUserDTO>();

		for (TennisUserDetailDTO tennisUserDTO : BeanMapper
				.mapList(this.startUsersModelList, TennisUserDetailDTO.class)) {
			user.add(tennisUserDTO);
		}
		return user;
	}

	/** get 收藏 */
	// @JsonIgnore
	// public List<TMTennisUser> getStartUsersModelList(){
	// return this.startUsersModelList;
	// }

	/** set 收藏 */
	public void setStartUsersModelList(List<TMTennisUser> startUsersModelList) {
		this.startUsersModelList = startUsersModelList;
	}

	// @JsonIgnore
	// public List<Long> getOwnersModelListIds() {
	// return Collections3.extractToList(this.ownersModelList, "id");
	// }

	public List<TennisUserDTO> getOwners_TennisUser_List() {
		List<TennisUserDTO> user = new ArrayList<TennisUserDTO>();

		for (TennisUserDetailDTO tennisUserDTO : BeanMapper.mapList(this.ownersModelList, TennisUserDetailDTO.class)) {
			user.add(tennisUserDTO);
		}
		return user;
	}

	/** get // 发起者 */
	// public List<TMTennisUser> getOwnersModelList(){
	// return this.ownersModelList;
	// }

	/** set // 发起者 */
	public void setOwnersModelList(List<TMTennisUser> ownersModelList) {
		this.ownersModelList = ownersModelList;
	}

	// @JsonIgnore
	// public List<Long> getParticipantModelListIds() {
	// return Collections3.extractToList(this.participantModelList, "id");
	// }

	public List<TennisUserDTO> getParticipant_TennisUser_List() {
		List<TennisUserDTO> user = new ArrayList<TennisUserDTO>();

		for (TennisUserDetailDTO tennisUserDTO : BeanMapper.mapList(this.participantModelList,
				TennisUserDetailDTO.class)) {
			user.add(tennisUserDTO);
		}
		return user;
	}

	/** get // 参与者 */
	// public List<TMTennisUser> getParticipantModelList(){
	// return this.participantModelList;
	// }

	/** set // 参与者 */
	public void setParticipantModelList(List<TMTennisUser> participantModelList) {
		this.participantModelList = participantModelList;
	}

	// @JsonIgnore
	// public List<Long> getEvaluatesModelListIds() {
	// return Collections3.extractToList(this.commentsModelList, "id");
	// }

	public List<EvaluateDTO> getComments_Evaluate_List() {
		return BeanMapper.mapList(this.commentsModelList, EvaluateDTO.class);
	}

	/** get 评论 */
	// public List<TMEvaluate> getEvaluatesModelList(){
	// return this.evaluatesModelList;
	// }

	/** set 评论 */
	public void setEvaluatesModelList(List<TMEvaluate> evaluatesModelList) {
		this.commentsModelList = evaluatesModelList;
	}

	// @JsonIgnore
	// public List<Long> getCourtsModelListIds() {
	// return Collections3.extractToList(this.courtsModelList, "id");
	// }

	public List<CourtDTO> getCourts_Court_List() {
		return BeanMapper.mapList(this.courtsModelList, CourtDTO.class);
	}

	/** get 场地 */
	// public List<TMCourt> getCourtsModelList(){
	// return this.courtsModelList;
	// }

	/** set 场地 */
	public void setCourtsModelList(List<TMCourt> courtsModelList) {
		this.courtsModelList = courtsModelList;
	}

	public static EventDetailDTO createByEvent4Detail(TMEvent event) {

		EventDetailDTO dto = BeanMapper.map(event, EventDetailDTO.class);
		dto.setStartUsersModelList(event.getStartUsers());
		dto.setOwnersModelList(event.getOwner());
		dto.setParticipantModelList(event.getParticipant());
		dto.setCourtsModelList(event.getCourtList());
		dto.setEvaluatesModelList(event.getComments());
		return dto;
	}

}

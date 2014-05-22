package org.springside.examples.quickstart.restdto;

public class TennisUserDetailWrapDTO {

	public TennisUserDetailDTO tennisUser_TennisUser_Model;

	public TennisUserDetailWrapDTO(TennisUserDetailDTO tennisUser_TennisUser_Model) {
		this.tennisUser_TennisUser_Model = tennisUser_TennisUser_Model;
	}

	public TennisUserDetailDTO getTennisUser_TennisUser_Model() {
		return tennisUser_TennisUser_Model;
	}

	public void setTennisUser_TennisUser_Model(TennisUserDetailDTO tennisUser_TennisUser_Model) {
		this.tennisUser_TennisUser_Model = tennisUser_TennisUser_Model;
	}

}

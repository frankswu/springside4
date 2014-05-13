package org.springside.examples.quickstart.restdto;

import java.util.List;

public class TennisUserListDTO {

	public List<TennisUserDTO> user_TennisUser_List;

	public List<TennisUserDTO> getUser_TennisUser_List() {
		return user_TennisUser_List;
	}

	public void setUser_TennisUser_List(List<TennisUserDTO> user_TennisUser_List) {
		this.user_TennisUser_List = user_TennisUser_List;
	}

	public TennisUserListDTO(List<TennisUserDTO> user_TennisUser_List) {
		this.user_TennisUser_List = user_TennisUser_List;
	}
}

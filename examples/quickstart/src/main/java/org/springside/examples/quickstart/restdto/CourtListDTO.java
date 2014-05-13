package org.springside.examples.quickstart.restdto;

import java.util.List;

public class CourtListDTO {

	private List<CourtDTO> court_Court_List;

	public List<CourtDTO> getCourt_Court_List() {
		return court_Court_List;
	}

	public void setCourt_Court_List(List<CourtDTO> court_Court_List) {
		this.court_Court_List = court_Court_List;
	}

	public CourtListDTO(List<CourtDTO> court_Court_List) {
		this.court_Court_List = court_Court_List;
	}
}

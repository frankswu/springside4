package org.springside.examples.quickstart.restdto;

public class CourtWrapDTO {

	public CourtDTO court_Court_Model;

	public CourtWrapDTO(CourtDTO court_Court_Model) {
		this.court_Court_Model = court_Court_Model;
	}

	public CourtDTO getCourt_Court_Model() {
		return court_Court_Model;
	}

	public void setCourt_Court_Model(CourtDTO court_Court_Model) {
		this.court_Court_Model = court_Court_Model;
	}

}

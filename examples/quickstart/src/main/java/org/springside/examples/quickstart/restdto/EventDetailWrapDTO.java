package org.springside.examples.quickstart.restdto;

public class EventDetailWrapDTO {

	public EventDetailDTO event_Event_Model;

	public EventDetailWrapDTO(EventDetailDTO event_Event_Model) {
		this.event_Event_Model = event_Event_Model;
	}

	public EventDetailDTO getEvent_Event_Model() {
		return event_Event_Model;
	}

	public void setEvent_Event_Model(EventDetailDTO event_Event_Model) {
		this.event_Event_Model = event_Event_Model;
	}

}

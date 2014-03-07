package org.springside.examples.quickstart.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "group_tb")
public class TGroup extends IdEntity {

	private String groupName;
	private String groupDesc;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupDesc() {
		return groupDesc;
	}

	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}

}

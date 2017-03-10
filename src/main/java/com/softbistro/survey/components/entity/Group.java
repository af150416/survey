package com.softbistro.survey.components.entity;

import java.io.Serializable;

public class Group implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer clientId;
	private String groupName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
}

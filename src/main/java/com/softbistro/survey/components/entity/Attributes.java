package com.softbistro.survey.components.entity;

import java.io.Serializable;

public class Attributes implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer groupId;
	private String attribute;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
}

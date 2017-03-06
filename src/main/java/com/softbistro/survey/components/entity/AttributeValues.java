package com.softbistro.survey.components.entity;

public class AttributeValues {
	private Integer id;
	private Integer participantId;
	private Integer attributeId;
	private String value;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParticipantId() {
		return participantId;
	}

	public void setParticipantId(Integer participantId) {
		this.participantId = participantId;
	}

	public Integer getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(Integer attributeId) {
		this.attributeId = attributeId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}

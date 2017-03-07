package com.softbistro.survey.components.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.softbistro.survey.components.entity.AttributeValues;
import com.softbistro.survey.components.interfaces.IAttributeValues;

public class AttributeValuesService {

	@Autowired
	IAttributeValues iAttributeValues;

	public Integer setAttributeValues(Integer attributeId, Integer participantId, String attributeValue) {
		return iAttributeValues.setAttributeValues(attributeId, participantId, attributeValue);
	}

	public AttributeValues getAttributeValues(Integer participantId, Integer attributeId) {
		return iAttributeValues.getAttributeValues(participantId, attributeId);
	}

	public Integer updateAttributeValues(Integer attributeId, Integer participantId, String attributeValue) {
		return iAttributeValues.updateAttributeValues(attributeId, participantId, attributeValue);
	}

	public Integer deleteAttributeValues(Integer attributeValuesId) {
		return iAttributeValues.deleteAttributeValues(attributeValuesId);
	}

}

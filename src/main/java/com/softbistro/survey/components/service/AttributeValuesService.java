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

	public AttributeValues getAttributeValuesById(Integer attributeValuesId) {
		return iAttributeValues.getAttributeValuesById(attributeValuesId);
	}

	public Integer updateAttributeValuesById(Integer attributeValuesId, String attributeValue) {
		return iAttributeValues.updateAttributeValuesById(attributeValuesId, attributeValue);
	}

	public Integer deleteAttributeValuesById(Integer attributeValuesId) {
		return iAttributeValues.deleteAttributeValuesById(attributeValuesId);
	}
}

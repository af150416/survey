package com.softbistro.survey.components.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softbistro.survey.components.entity.AttributeValues;
import com.softbistro.survey.components.interfaces.IAttributeValues;

@Service
public class AttributeValuesService {

	@Autowired
	IAttributeValues iAttributeValues;

	public Integer setAttributeValues(AttributeValues attributeValues) {
		return iAttributeValues.setAttributeValues(attributeValues);
	}

	public AttributeValues getAttributeValuesById(Integer attributeValuesId) {
		return iAttributeValues.getAttributeValuesById(attributeValuesId);
	}

	public Integer updateAttributeValuesById(AttributeValues attributeValues) {
		return iAttributeValues.updateAttributeValuesById(attributeValues);
	}

	public Integer deleteAttributeValuesById(Integer attributeValuesId) {
		return iAttributeValues.deleteAttributeValuesById(attributeValuesId);
	}
}

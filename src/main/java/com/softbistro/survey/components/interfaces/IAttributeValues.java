package com.softbistro.survey.components.interfaces;

import com.softbistro.survey.components.entity.AttributeValues;

public interface IAttributeValues {

	public Integer setAttributeValues(Integer attributeId, Integer participantId, String attributeValue);

	public AttributeValues getAttributeValuesById(Integer attributeValuesId);

	public Integer updateAttributeValuesById(Integer attributeValuesId, String attributeValue);

	public Integer deleteAttributeValuesById(Integer attributeValuesId);
}

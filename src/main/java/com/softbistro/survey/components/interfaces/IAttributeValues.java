package com.softbistro.survey.components.interfaces;

import com.softbistro.survey.components.entity.AttributeValues;

public interface IAttributeValues {

	public Integer setAttributeValues(Integer attributeId, Integer participantId, String attributeValue);

	public AttributeValues getAttributeValues(Integer participantId, Integer attributeId);

	public Integer updateAttributeValues(Integer attributeId, Integer participantId, String attributeValue);

	public Integer deleteAttributeValues(Integer attributeValuesId);
}

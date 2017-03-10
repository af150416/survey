package com.softbistro.survey.components.interfaces;

import com.softbistro.survey.components.entity.AttributeValues;

public interface IAttributeValues {

	public Integer setAttributeValues(AttributeValues attributeValues);

	public AttributeValues getAttributeValuesById(Integer attributeValuesId);

	public Integer updateAttributeValuesById(AttributeValues attributeValues);

	public Integer deleteAttributeValuesById(Integer attributeValuesId);
}

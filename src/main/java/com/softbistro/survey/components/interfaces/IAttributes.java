package com.softbistro.survey.components.interfaces;

import java.util.List;

import com.softbistro.survey.components.entity.Attributes;

public interface IAttributes {
	
	public Integer setAttribute(Integer group_id, String attribute);

	public Attributes getAttributeById(Integer attributesId);

	public Integer updateAttributes(Integer attributeId, Integer groupId, String attribute);

	public Integer deleteAttributes(Integer attributesId);
	
	public List<Attributes> getAttributesByGroup(Integer groupId);
}

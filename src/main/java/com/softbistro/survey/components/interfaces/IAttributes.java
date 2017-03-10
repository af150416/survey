package com.softbistro.survey.components.interfaces;

import java.util.List;

import com.softbistro.survey.components.entity.Attributes;

public interface IAttributes {

	public Integer setAttribute(Attributes attributes);

	public Attributes getAttributeById(Integer attributesId);

	public Integer updateAttributes(Attributes attributes);

	public Integer deleteAttributes(Integer attributesId);

	public List<Attributes> getAttributesByGroup(Integer groupId);
}

package com.softbistro.survey.components.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softbistro.survey.components.entity.Attributes;
import com.softbistro.survey.components.interfaces.IAttributes;

@Service
public class AttributesService {

	@Autowired
	IAttributes iAttributes;

	public Integer setAttribute(Integer group_id, String attribute) {
		return iAttributes.setAttribute(group_id, attribute);
	}

	public Attributes getAttributeById(Integer attributesId) {
		return iAttributes.getAttributeById(attributesId);
	}

	public Integer updateAttributes(Integer attributeId, Integer groupId, String attribute) {
		return iAttributes.updateAttributes(attributeId, groupId, attribute);
	}

	public Integer deleteAttributes(Integer attributesId) {
		return iAttributes.deleteAttributes(attributesId);
	}
	
	public List<Attributes> getAttributesByGroup(Integer groupId){
		return (List<Attributes>) iAttributes.getAttributesByGroup(groupId);
	}
}

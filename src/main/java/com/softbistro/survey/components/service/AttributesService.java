package com.softbistro.survey.components.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softbistro.survey.components.entity.Attributes;
import com.softbistro.survey.components.interfaces.IAttributes;


/**
 * Service for attribute entity
 * @author af150416
 *
 */
@Service
public class AttributesService {

	@Autowired
	IAttributes iAttributes;

	/**Method for creating the attribute value
	 * @param attributes
	 * @return int status of method executing where (0 = Failed, 1 = Succeeded, 3 = Canceled, 5 = Unknown)
	 */
	public Integer setAttribute(Attributes attributes) {
		return iAttributes.setAttribute(attributes);
	}

	/**
	 * Method for getting attribute by id
	 * @param attributesId
	 * @return Attributes
	 */
	public Attributes getAttributeById(Integer attributesId) {
		return iAttributes.getAttributeById(attributesId);
	}

	/**
	 * Method for updating attribute
	 * @param attributes
	 * @return int status of method executing where (0 = Failed, 1 = Succeeded, 3 = Canceled, 5 = Unknown)
	 */
	public Integer updateAttributes(Attributes attributes) {
		return iAttributes.updateAttributes(attributes);
	}

	/**
	 * Method for deleting attributes by id
	 * @param attributesId
	 * @return int status of method executing where (0 = Failed, 1 = Succeeded, 3 = Canceled, 5 = Unknown)
	 */
	public Integer deleteAttributes(Integer attributesId) {
		return iAttributes.deleteAttributes(attributesId);
	}
	
	/**
	 * Method to getting all attributes by group
	 * @param groupId
	 * @return List<Attributes>
	 */
	public List<Attributes> getAttributesByGroup(Integer groupId){
		return (List<Attributes>) iAttributes.getAttributesByGroup(groupId);
	}
}

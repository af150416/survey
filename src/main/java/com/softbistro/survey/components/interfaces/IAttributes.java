package com.softbistro.survey.components.interfaces;

import java.util.List;

import com.softbistro.survey.components.entity.Attributes;
import com.softbistro.survey.components.entity.ExecutingStatus;

/**
 * Interface for attributes value
 * 
 * @author af150416
 *
 */
public interface IAttributes {

	/**
	 * Method for creating the attribute value
	 * 
	 * @param attributes
	 * @return ExecutingStatus
	 */
	public ExecutingStatus setAttribute(Attributes attributes);

	/**
	 * Method for getting attribute by id
	 * 
	 * @param attributesId
	 * @return Attributes
	 */
	public Attributes getAttributeById(Integer attributesId);

	/**
	 * Method for updating attribute
	 * 
	 * @param attributes
	 * @return ExecutingStatus
	 */
	public ExecutingStatus updateAttributes(Attributes attributes);

	/**
	 * Method for deleting attributes by id
	 * 
	 * @param attributesId
	 * @return ExecutingStatus
	 */
	public ExecutingStatus deleteAttributes(Integer attributesId);

	/**
	 * Method to getting all attributes in group
	 * 
	 * @param groupId
	 * @return List<Attributes>
	 */
	public List<Attributes> getAttributesByGroup(Integer groupId);
}

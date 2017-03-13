package com.softbistro.survey.components.interfaces;

import java.util.List;

import com.softbistro.survey.components.entity.Attributes;


/**
 * Interface for attributes value
 * @author af150416
 *
 */
public interface IAttributes {

	/**Method for creating the attribute value
	 * @param attributes
	 * @return int status of method executing where (0 = Failed, 1 = Succeeded, 3 = Canceled, 5 = Unknown)
	 */
	public Integer setAttribute(Attributes attributes);

	/**
	 * Method for getting attribute by id
	 * @param attributesId
	 * @return Attributes
	 */
	public Attributes getAttributeById(Integer attributesId);

	/**
	 * Method for updating attribute
	 * @param attributes
	 * @return int status of method executing where (0 = Failed, 1 = Succeeded, 3 = Canceled, 5 = Unknown)
	 */
	public Integer updateAttributes(Attributes attributes);

	/**
	 * Method for deleting attributes by id
	 * @param attributesId
	 * @return int status of method executing where (0 = Failed, 1 = Succeeded, 3 = Canceled, 5 = Unknown)
	 */
	public Integer deleteAttributes(Integer attributesId);

	/**
	 * Method to getting all attributes in group
	 * @param groupId
	 * @return List<Attributes>
	 */
	public List<Attributes> getAttributesByGroup(Integer groupId);
}

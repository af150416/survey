package com.softbistro.survey.components.interfaces;

import java.util.List;

import com.softbistro.survey.components.entity.AttributeValues;

/**
 * Interface for attribute values entity
 * @author af150416
 *
 */
public interface IAttributeValues {

	/**
	 * Method for creating attribute values
	 * @param attributeValues
	 * @return int status of method executing where (0 = Failed, 1 = Succeeded, 3 = Canceled, 5 = Unknown)
	 */
	public Integer setAttributeValues(AttributeValues attributeValues);

	/**
	 * Method for getting attribute values form the db
	 * @param attributeValuesId
	 * @return AttributeValues
	 */
	public AttributeValues getAttributeValuesById(Integer attributeValuesId);

	/**
	 * Method for updating attribute values 
	 * @param attributeValues
	 * @return int status of method executing where (0 = Failed, 1 = Succeeded, 3 = Canceled, 5 = Unknown)
	 */
	public Integer updateAttributeValuesById(AttributeValues attributeValues);

	/**
	 * Method for deleting attribute values by id
	 * @param attributeValuesId
	 * @return int status of method executing where (0 = Failed, 1 = Succeeded, 3 = Canceled, 5 = Unknown)
	 */
	public Integer deleteAttributeValuesById(Integer attributeValuesId);
	
	/**
	 * Method for getting all attribute values of participant in group
	 * @param groupId
	 * @param participantId
	 * @return List<AttributeValues>
	 */
	public List<AttributeValues> getParticipantAttributesInGroup(Integer groupId, Integer participantId);

}

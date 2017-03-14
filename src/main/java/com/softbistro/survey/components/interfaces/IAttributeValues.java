package com.softbistro.survey.components.interfaces;

import java.util.List;

import com.softbistro.survey.components.entity.AttributeValues;
import com.softbistro.survey.components.entity.ExecutingStatus;

/**
 * Interface for attribute values entity
 * 
 * @author af150416
 *
 */
public interface IAttributeValues {

	/**
	 * Method for creating attribute values
	 * 
	 * @param attributeValues
	 * @return ExecutingStatus
	 */
	public ExecutingStatus setAttributeValues(AttributeValues attributeValues);

	/**
	 * Method for getting attribute values form the db
	 * 
	 * @param attributeValuesId
	 * @return AttributeValues
	 */
	public AttributeValues getAttributeValuesById(Integer attributeValuesId);

	/**
	 * Method for updating attribute values
	 * 
	 * @param attributeValues
	 * @return ExecutingStatus
	 */
	public ExecutingStatus updateAttributeValuesById(AttributeValues attributeValues);

	/**
	 * Method for deleting attribute values by id
	 * 
	 * @param attributeValuesId
	 * @return ExecutingStatus
	 */
	public ExecutingStatus deleteAttributeValuesById(Integer attributeValuesId);

	/**
	 * Method for getting all attribute values of participant in group
	 * 
	 * @param groupId
	 * @param participantId
	 * @return List<AttributeValues>
	 */
	public List<AttributeValues> getParticipantAttributesInGroup(Integer groupId, Integer participantId);

}

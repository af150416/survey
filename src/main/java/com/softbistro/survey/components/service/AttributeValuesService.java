package com.softbistro.survey.components.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softbistro.survey.components.entity.AttributeValues;
import com.softbistro.survey.components.entity.ExecutingStatus;
import com.softbistro.survey.components.interfaces.IAttributeValues;

/**
 * Service for attribute Values entity
 * @author af150416
 *
 */
@Service
public class AttributeValuesService {

	@Autowired
	IAttributeValues iAttributeValues;
	
	/**
	 * Method for creating attribute values
	 * @param attributeValues
	 * @return ExecutingStatus
	 */
	 public ExecutingStatus setAttributeValues(AttributeValues attributeValues) {
		return iAttributeValues.setAttributeValues(attributeValues);
	}
	/**
	 * Method for getting attribute values form the db
	 * @param attributeValuesId
	 * @return AttributeValues
	 */
	public AttributeValues getAttributeValuesById(Integer attributeValuesId) {
		return iAttributeValues.getAttributeValuesById(attributeValuesId);
	}

	/**
	 * Method for updating attribute values 
	 * @param attributeValues
	 * @return ExecutingStatus
	 */
	 public ExecutingStatus updateAttributeValuesById(AttributeValues attributeValues) {
		return iAttributeValues.updateAttributeValuesById(attributeValues);
	}
	/**
	 * Method for deleting attribute values by id
	 * @param attributeValuesId
	 * @return ExecutingStatus
	 */
	 public ExecutingStatus deleteAttributeValuesById(Integer attributeValuesId) {
		return iAttributeValues.deleteAttributeValuesById(attributeValuesId);
	}
	
	/**
	 * Method for getting all attribute values of participant in group
	 * @param groupId
	 * @param participantId
	 * @return List<AttributeValues>
	 */
	public List<AttributeValues> getParticipantAttributesInGroup(Integer groupId, Integer participantId){
		return iAttributeValues.getParticipantAttributesInGroup(groupId, participantId);
	}
}

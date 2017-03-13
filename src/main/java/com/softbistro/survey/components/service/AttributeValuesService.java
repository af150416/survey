package com.softbistro.survey.components.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softbistro.survey.components.entity.AttributeValues;
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
	 * @return int status of method executing where (0 = Failed, 1 = Succeeded, 3 = Canceled, 5 = Unknown)
	 */
	public Integer setAttributeValues(AttributeValues attributeValues) {
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
	 * @return int status of method executing where (0 = Failed, 1 = Succeeded, 3 = Canceled, 5 = Unknown)
	 */
	public Integer updateAttributeValuesById(AttributeValues attributeValues) {
		return iAttributeValues.updateAttributeValuesById(attributeValues);
	}
	/**
	 * Method for deleting attribute values by id
	 * @param attributeValuesId
	 * @return int status of method executing where (0 = Failed, 1 = Succeeded, 3 = Canceled, 5 = Unknown)
	 */
	public Integer deleteAttributeValuesById(Integer attributeValuesId) {
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

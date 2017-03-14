package com.softbistro.survey.components.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.softbistro.survey.components.entity.AttributeValues;
import com.softbistro.survey.components.entity.ExecutingStatus;
import com.softbistro.survey.components.service.AttributeValuesService;

/**
 * Controller for attribute values entity
 * 
 * @author af150416
 *
 */
@RestController
@RequestMapping("/attributeValues")
public class AttributeValuesController {

	@Autowired
	AttributeValuesService attributeValuesService;

	/**
	 * Method for creating attribute values
	 * 
	 * @param attributeValues
	 * @return ExecutingStatus
	 */
	@RequestMapping(value = "/set", method = RequestMethod.PUT)
	public ExecutingStatus setAttributeValues(@RequestBody AttributeValues attributeValues) {
		return attributeValuesService.setAttributeValues(attributeValues);
	}

	/**
	 * Method for getting attribute values form the db
	 * 
	 * @param attributeValuesId
	 * @return AttributeValues
	 */
	@RequestMapping(value = "/get/{attributeValuesId}", method = RequestMethod.GET)
	public AttributeValues getAttributevaluesById(@PathVariable Integer attributeValuesId) {
		return attributeValuesService.getAttributeValuesById(attributeValuesId);
	}

	/**
	 * Method for updating attribute values
	 * 
	 * @param attributeValues
	 * @return ExecutingStatus
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ExecutingStatus updateAttributeValuesById(@RequestBody AttributeValues attributeValues) {
		return attributeValuesService.updateAttributeValuesById(attributeValues);
	}

	/**
	 * Method for deleting attribute values by id
	 * 
	 * @param attributeValuesId
	 * @return ExecutingStatus
	 */
	@RequestMapping(value = "/delete/{attributeValuesId}", method = RequestMethod.DELETE)
	public ExecutingStatus deleteAttributeValuesById(@PathVariable Integer attributeValuesId) {
		return attributeValuesService.deleteAttributeValuesById(attributeValuesId);
	}

	/**
	 * Method for getting all attribute values of participant in group
	 * 
	 * @param groupId
	 * @param participantId
	 * @return List<AttributeValues>
	 */
	@RequestMapping(value = "/getAttributesByGroup/{groupId}/{participantId}", method = RequestMethod.GET)
	public List<AttributeValues> getParticipantAttributeValuesInGroup(@PathVariable Integer groupId,
			Integer participantId) {
		return attributeValuesService.getParticipantAttributesInGroup(groupId, participantId);
	}
}

package com.softbistro.survey.components.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.softbistro.survey.components.entity.Attributes;
import com.softbistro.survey.components.entity.ExecutingStatus;
import com.softbistro.survey.components.service.AttributesService;

/**
 * Controller
 * 
 * @author af150416
 *
 */
@RestController
@RequestMapping("/attributes")
public class AttributesController {

	@Autowired
	AttributesService attributesService;

	/**
	 * Method for creating the attribute value
	 * 
	 * @param attributes
	 * @return ExecutingStatus
	 */
	@RequestMapping(value = "/set", method = RequestMethod.PUT)
	public ExecutingStatus setAttribute(@RequestBody Attributes attributes) {
		return attributesService.setAttribute(attributes);
	}

	/**
	 * Method for getting attribute by id
	 * 
	 * @param attributesId
	 * @return Attributes
	 */
	@RequestMapping(value = "/getById/{attributesId}", method = RequestMethod.GET)
	public Attributes getAttributesById(@PathVariable Integer attributesId) {
		return attributesService.getAttributeById(attributesId);
	}

	/**
	 * Method to getting all attributes on group
	 * 
	 * @param groupId
	 * @return List<Attributes>
	 */
	@RequestMapping(value = "/getByGroup/{groupId}", method = RequestMethod.GET)
	public List<Attributes> getAttributesByGroup(@PathVariable Integer groupId) {
		return attributesService.getAttributesByGroup(groupId);
	}

	/**
	 * Method for updating attribute
	 * 
	 * @param attributes
	 * @return ExecutingStatus
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ExecutingStatus updateAttributesById(@RequestBody Attributes attributes) {
		return attributesService.updateAttributes(attributes);
	}

	/**
	 * Method for deleting attributes by id
	 * 
	 * @param attributesId
	 * @return ExecutingStatus
	 */
	@RequestMapping(value = "/delete/{attributesId}", method = RequestMethod.DELETE)
	public ExecutingStatus deleteAttributesById(@PathVariable Integer attributesId) {
		return attributesService.deleteAttributes(attributesId);
	}
}
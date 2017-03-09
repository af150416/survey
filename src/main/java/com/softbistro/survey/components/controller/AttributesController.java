package com.softbistro.survey.components.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.softbistro.survey.components.entity.Attributes;
import com.softbistro.survey.components.service.AttributesService;

@RestController
@RequestMapping("/attributes")
public class AttributesController {

	@Autowired
	AttributesService attributesService;

	@RequestMapping(value = "/settingAttribute", method = RequestMethod.PUT)
	public Integer setAttribute(@RequestBody Integer groupId, String attribute) {
		return attributesService.setAttribute(groupId, attribute);
	}

	@RequestMapping(value = "/getAttributeById/{attributesId}", method = RequestMethod.GET)
	public Attributes getAttributesById(@PathVariable Integer attributesId) {
		return attributesService.getAttributeById(attributesId);
	}

	@RequestMapping(value = "/getAttributeByGroup/{groupId}", method = RequestMethod.GET)
	public List<Attributes> getAttributesByGroup(@PathVariable Integer groupId) {
		return attributesService.getAttributesByGroup(groupId);
	}
	
	@RequestMapping(value = "/updateAtributeById", method = RequestMethod.PUT)
	public Integer updateAttributesById(@RequestBody Integer attributeId, Integer groupId, String attribute){
		return attributesService.updateAttributes(attributeId, groupId, attribute);
	}
	
	@RequestMapping(value = "/deleteAttributeById/{attributesId}", method = RequestMethod.DELETE)
	public Integer deleteAttributesById(@PathVariable Integer attributesId){
		return attributesService.deleteAttributes(attributesId);
	}
}
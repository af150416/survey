package com.softbistro.survey.components.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.softbistro.survey.components.entity.AttributeValues;
import com.softbistro.survey.components.service.AttributeValuesService;

@RestController
@RequestMapping("/attributeValues")
public class AttributeValuesController {

	@Autowired
	AttributeValuesService attributeValuesService;

	@RequestMapping(value = "/set", method = RequestMethod.PUT)
	public Integer setAttributeValues(@RequestBody AttributeValues attributeValues) {
		return attributeValuesService.setAttributeValues(attributeValues);
	}

	@RequestMapping(value = "/get/{attributeValuesId}", method = RequestMethod.GET)
	public AttributeValues getAttributevaluesById(@PathVariable Integer attributeValuesId) {
		return attributeValuesService.getAttributeValuesById(attributeValuesId);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Integer updateAttributeValuesById(@RequestBody AttributeValues attributeValues) {
		return attributeValuesService.updateAttributeValuesById(attributeValues);
	}

	@RequestMapping(value = "/delete/{attributeValuesId}", method = RequestMethod.DELETE)
	public Integer deleteAttributeValuesById(@PathVariable Integer attributeValuesId) {
		return attributeValuesService.deleteAttributeValuesById(attributeValuesId);
	}

}

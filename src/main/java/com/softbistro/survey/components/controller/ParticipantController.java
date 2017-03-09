package com.softbistro.survey.components.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.softbistro.survey.components.entity.AttributeValues;
import com.softbistro.survey.components.entity.Participant;
import com.softbistro.survey.components.service.ParticipantService;

@RestController
@RequestMapping("/participant")
public class ParticipantController {

	@Autowired
	ParticipantService participantService;

	@RequestMapping(value = "/participantsByGroup/{id}", method = RequestMethod.GET)
	public List<Participant> getParticipantsByGroup(@PathVariable Integer id) {
		return participantService.getParticipantsByGroup(id);
	}
	
	@RequestMapping(value = "/getParticipantAttributesInGroup/{groupId}/{participantId}", method = RequestMethod.GET)
	public List<AttributeValues> getParticipantAttributeValuesInGroup(@PathVariable Integer groupId, Integer participantId){
		return participantService.getParticipantAttributesInGroup(groupId, participantId);
	}
	
	@RequestMapping(value = "/getParticipantById/{id}", method = RequestMethod.GET)
	public Participant getParticipantById(@PathVariable Integer participantId){
		return participantService.getParticipantById(participantId);
	}
	
	@RequestMapping(value = "/setParticipant", method = RequestMethod.PUT)
	public Integer setParticipant(@RequestBody String firstName, String lastName, String email, String password) {
		return participantService.setParticipant(firstName, lastName, email, password);
	}
	
	@RequestMapping(value = "/updateParticipant", method = RequestMethod.PUT)
	public Integer updateParticipant(@RequestBody String firstName, String lastName, String email, String password){
		return participantService.updateParticipant(firstName, lastName, email, password);
	}
	
	@RequestMapping(value = "/deleteParticipant/{id}", method = RequestMethod.DELETE)
	public Integer deleteParticipant(@PathVariable Integer id){
		return participantService.deleteParticipant(id);
		
	}

}

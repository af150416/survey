package com.softbistro.survey.components.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping(value = "/participantsInGroup/{id}", method = RequestMethod.GET)
	public List<Participant> getParticipantsByGroup(@PathVariable Integer id) {
		return participantService.getParticipantsByGroup(id);
	}
	
	@RequestMapping(value = "/participant/{id}/attributes", method = RequestMethod.GET)
	public List<AttributeValues> getParticipantAttributes(@PathVariable Integer participantId){
		return participantService.getParticipantAttributes(participantId);
	}

}

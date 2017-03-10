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

	@RequestMapping(value = "/getByGroup/{id}", method = RequestMethod.GET)
	public List<Participant> getParticipantsByGroup(@PathVariable Integer id) {
		return participantService.getParticipantsByGroup(id);
	}

	@RequestMapping(value = "/getAttributesByGroup/{groupId}/{participantId}", method = RequestMethod.GET)
	public List<AttributeValues> getParticipantAttributeValuesInGroup(@PathVariable Integer groupId,
			Integer participantId) {
		return participantService.getParticipantAttributesInGroup(groupId, participantId);
	}

	@RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
	public Participant getParticipantById(@PathVariable Integer participantId) {
		return participantService.getParticipantById(participantId);
	}

	@RequestMapping(value = "/set", method = RequestMethod.POST)
	public Integer setParticipant(@RequestBody Participant participant) {
		return participantService.setParticipant(participant);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Integer updateParticipant(@RequestBody Participant participant) {
		return participantService.updateParticipant(participant);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public Integer deleteParticipant(@PathVariable Integer id) {
		return participantService.deleteParticipant(id);

	}
}

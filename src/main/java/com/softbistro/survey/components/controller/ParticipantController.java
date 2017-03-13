package com.softbistro.survey.components.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.softbistro.survey.components.entity.ExecutingStatus;
import com.softbistro.survey.components.entity.Participant;
import com.softbistro.survey.components.service.ParticipantService;

/**
 * Controller for participant entity
 * @author af150416
 *
 */
@RestController
@RequestMapping("/participant")
public class ParticipantController {

	@Autowired
	ParticipantService participantService;

	/**
	 * Method for getting all participant by group
	 * @param groupId
	 * @return List<Participant>
	 */
	@RequestMapping(value = "/getByGroup/{groupId}", method = RequestMethod.GET)
	public List<Participant> getParticipantsByGroup(@PathVariable Integer groupId) {
		return participantService.getParticipantsByGroup(groupId);
	}

	/**
	 * Method to getting  participant from db by id
	 * @param participantId
	 * @return Participant
	 */
	@RequestMapping(value = "/getById/{participantId}", method = RequestMethod.GET)
	public Participant getParticipantById(@PathVariable Integer participantId) {
		return participantService.getParticipantById(participantId);
	}

	/**Method for creating participant 
	 * @param participant
	 * @return ExecutingStatus
	 */
	@RequestMapping(value = "/set", method = RequestMethod.POST)
	 public ExecutingStatus setParticipant(@RequestBody Participant participant) {
		return participantService.setParticipant(participant);
	}

	/**
	 * Method for updating participant
	 * @param participant
	 * @return ExecutingStatus
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	 public ExecutingStatus updateParticipant(@RequestBody Participant participant) {
		return participantService.updateParticipant(participant);
	}

	/**
	 * Method for deleting participant from db by email
	 * @param email
	 * @return ExecutingStatus
	 */
	@RequestMapping(value = "/delete/{participantId}", method = RequestMethod.DELETE)
	 public ExecutingStatus deleteParticipant(@PathVariable String email) {
		return participantService.deleteParticipant(email);

	}
}

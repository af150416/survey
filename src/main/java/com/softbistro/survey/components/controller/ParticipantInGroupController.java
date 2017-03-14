package com.softbistro.survey.components.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.softbistro.survey.components.entity.ExecutingStatus;
import com.softbistro.survey.components.entity.Group;
import com.softbistro.survey.components.entity.Participant;
import com.softbistro.survey.components.entity.ParticipantInGroup;
import com.softbistro.survey.components.service.ParticipantInGroupService;

/**
 * Controller for participantInGroup entity
 * 
 * @author af150416
 *
 */
@RestController
@RequestMapping("/participantInGroup")
public class ParticipantInGroupController {

	@Autowired
	ParticipantInGroupService participantInGroupService;

	/**
	 * Method for getting all participant by group
	 * 
	 * @param groupId
	 * @return List<Participant>
	 */
	@RequestMapping(value = "/getParticipantsByGroup/{groupId}", method = RequestMethod.GET)
	public List<Participant> getParticipantsByGroup(@PathVariable Integer groupId) {
		return participantInGroupService.getParticipantsByGroup(groupId);
	}

	/**
	 * Method for adding participant in group
	 * 
	 * @param groupId
	 * @param participantId
	 * @return ExecutingStatus
	 */
	@RequestMapping(value = "/addParticipantInGroup", method = RequestMethod.PUT)
	public ExecutingStatus addParticipantInGroup(@RequestBody ParticipantInGroup participantInGoup) {
		return participantInGroupService.addParticipantInGroup(participantInGoup);
	}

	/**
	 * Method for deleting participant from group
	 * 
	 * @param groupId
	 * @param participantId
	 * @return ExecutingStatus
	 */
	@RequestMapping(value = "/deleteParticipantFromGroup/{groupId}/{participantId}", method = RequestMethod.DELETE)
	public ExecutingStatus deletingParticipantfromGroup(@PathVariable Integer groupId, Participant participantId) {
		return participantInGroupService.deletingParticipantfromGroup(groupId, participantId);
	}

	/**
	 * Method for getting all participant groups
	 * 
	 * @param participantId
	 * @return
	 */
	@RequestMapping(value = "/getParticipantGroups", method = RequestMethod.GET)
	public List<Group> getParticipantGroups(Integer participantId) {
		return participantInGroupService.getParticipantGroups(participantId);
	}
}

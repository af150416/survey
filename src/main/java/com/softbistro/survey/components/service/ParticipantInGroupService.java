package com.softbistro.survey.components.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softbistro.survey.components.entity.ExecutingStatus;
import com.softbistro.survey.components.entity.Group;
import com.softbistro.survey.components.entity.Participant;
import com.softbistro.survey.components.entity.ParticipantInGroup;
import com.softbistro.survey.components.interfaces.IParticipantInGroup;

/**
 * Service for ParticipantInGroup entity
 * 
 * @author af150416
 *
 */
@Service
public class ParticipantInGroupService {

	@Autowired
	IParticipantInGroup iparticipantInGroup;

	/**
	 * Method for getting all participant by group
	 * 
	 * @param groupId
	 * @return List<Participant>
	 */
	public List<Participant> getParticipantsByGroup(Integer groupId) {
		return iparticipantInGroup.getParticipantsByGroup(groupId);
	}

	/**
	 * Method for adding participant in group
	 * 
	 * @param groupId
	 * @param participantId
	 * @return ExecutingStatus
	 */
	public ExecutingStatus addParticipantInGroup(ParticipantInGroup participantInGoup) {
		return iparticipantInGroup.addParticipantInGroup(participantInGoup);
	}

	/**
	 * Method for deleting participant from group
	 * 
	 * @param groupId
	 * @param participantId
	 * @return ExecutingStatus
	 */
	public ExecutingStatus deletingParticipantfromGroup(Integer groupId, Participant participantId) {
		return iparticipantInGroup.deletingParticipantfromGroup(groupId, participantId);
	}

	/**
	 * Method for getting all participant groups
	 * 
	 * @param participantId
	 * @return
	 */
	public List<Group> getParticipantGroups(Integer participantId) {
		return iparticipantInGroup.getParticipantGroups(participantId);
	}
}

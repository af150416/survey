package com.softbistro.survey.components.interfaces;

import java.util.List;

import com.softbistro.survey.components.entity.ExecutingStatus;
import com.softbistro.survey.components.entity.Group;
import com.softbistro.survey.components.entity.Participant;
import com.softbistro.survey.components.entity.ParticipantInGroup;

/**
 * Interface for participaantInGroup entity
 * 
 * @author af150416
 *
 */
public interface IParticipantInGroup {

	/**
	 * Method for adding participant in group
	 * 
	 * @param groupId
	 * @param participantId
	 * @return ExecutingStatus
	 */
	public ExecutingStatus addParticipantInGroup(ParticipantInGroup participantInGoup);

	/**
	 * Method for deleting participant from group
	 * 
	 * @param groupId
	 * @param participantId
	 * @return ExecutingStatus
	 */
	public ExecutingStatus deletingParticipantfromGroup(Integer groupId, Participant participantId);

	/**
	 * Method for getting all participant by group
	 * 
	 * @param groupId
	 * @return List<Participant>
	 */
	public List<Participant> getParticipantsByGroup(Integer groupId);

	/**
	 * Method for getting all participant groups
	 * 
	 * @param participantId
	 * @return
	 */
	public List<Group> getParticipantGroups(Integer participantId);
}

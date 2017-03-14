package com.softbistro.survey.components.interfaces;

import com.softbistro.survey.components.entity.ExecutingStatus;
import com.softbistro.survey.components.entity.Participant;

/**
 * Interface for participant entity
 * 
 * @author af150416
 *
 */
public interface IParticipant {

	/**
	 * Method for creating participant
	 * 
	 * @param participant
	 * @return ExecutingStatus
	 */
	public ExecutingStatus setParticipant(Participant participant);

	/**
	 * Method for updating participant
	 * 
	 * @param participant
	 * @return ExecutingStatus
	 */
	public ExecutingStatus updateParticipant(Participant participant);

	/**
	 * Method for deleting participant from db by id
	 * 
	 * @param participantId
	 * @return ExecutingStatus
	 */
	public ExecutingStatus deleteParticipant(Integer participantId);

	/**
	 * Method to getting participant from db by id
	 * 
	 * @param participantId
	 * @return Participant
	 */
	public Participant getParticipantById(Integer participantId);
}

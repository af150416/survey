package com.softbistro.survey.components.interfaces;

import java.util.List;

import com.softbistro.survey.components.entity.Participant;


/**
 * Interface for participant entity
 * @author af150416
 *
 */
public interface IParticipant {

	/**Method for creating participant 
	 * @param participant
	 * @return int status of method executing where (0 = Failed, 1 = Succeeded, 3 = Canceled, 5 = Unknown)
	 */
	public Integer setParticipant(Participant participant);

	/**
	 * Method for getting all participant by group
	 * @param groupId
	 * @return List<Participant>
	 */
	public List<Participant> getParticipantsByGroup(Integer groupId);

	/**
	 * Method for updating participant
	 * @param participant
	 * @return int status of method executing where (0 = Failed, 1 = Succeeded, 3 = Canceled, 5 = Unknown)
	 */
	public Integer updateParticipant(Participant participant);
	
	/**
	 * Method for deleting participant from db by id
	 * @param id
	 * @return int status of method executing where (0 = Failed, 1 = Succeeded, 3 = Canceled, 5 = Unknown)
	 */
	public Integer deleteParticipant(Integer participantId);

	/**
	 * Method to getting  participant from db by id
	 * @param participantId
	 * @return Participant
	 */
	public Participant getParticipantById(Integer participantId);
}

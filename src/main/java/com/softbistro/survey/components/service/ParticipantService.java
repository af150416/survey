package com.softbistro.survey.components.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softbistro.survey.components.entity.ExecutingStatus;
import com.softbistro.survey.components.entity.Participant;
import com.softbistro.survey.components.interfaces.IParticipant;

/**
 * Service for participant entity
 * 
 * @author af150416
 *
 */
@Service
public class ParticipantService {

	@Autowired
	IParticipant iParticipant;

	/**
	 * Method for creating participant
	 * 
	 * @param participant
	 * @return ExecutingStatus
	 */
	public ExecutingStatus setParticipant(Participant participant) {
		return iParticipant.setParticipant(participant);
	}

	/**
	 * Method for updating participant
	 * 
	 * @param participant
	 * @return ExecutingStatus
	 */
	public ExecutingStatus updateParticipant(Participant participant) {
		return iParticipant.updateParticipant(participant);
	}

	/**
	 * Method for deleting participant from db by id
	 * 
	 * @param participantId
	 * @return ExecutingStatus
	 */
	public ExecutingStatus deleteParticipant(Integer participantId) {
		return iParticipant.deleteParticipant(participantId);
	}

	/**
	 * Method to getting participant from db by id
	 * 
	 * @param participantId
	 * @return Participant
	 */
	public Participant getParticipantById(Integer participantId) {
		return iParticipant.getParticipantById(participantId);
	}
}

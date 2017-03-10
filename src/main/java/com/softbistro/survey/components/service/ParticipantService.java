package com.softbistro.survey.components.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softbistro.survey.components.entity.AttributeValues;
import com.softbistro.survey.components.entity.Participant;
import com.softbistro.survey.components.interfaces.IParticipant;

@Service
public class ParticipantService {

	@Autowired
	IParticipant iParticipant;

	public Integer setParticipant(Participant participant){
		return iParticipant.setParticipant(participant);
	}
	
	public List<Participant> getParticipantsByGroup(Integer groupId) {
		return iParticipant.getParticipantsByGroup(groupId);
	}
	
	public List<AttributeValues> getParticipantAttributesInGroup(Integer groupId, Integer participantId){
		return iParticipant.getParticipantAttributesInGroup(groupId, participantId);
	}

	public Integer updateParticipant(Participant participant){
		return iParticipant.updateParticipant(participant);
	}
	
	public Integer deleteParticipant(Integer participantId){
		return iParticipant.deleteParticipant(participantId);
	}
	
	public Participant getParticipantById(Integer participantId){
		return iParticipant.getParticipantById(participantId);
	}
}

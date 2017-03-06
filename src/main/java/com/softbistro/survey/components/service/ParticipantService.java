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

	public List<Participant> getParticipantsByGroup(Integer groupId) {
		return iParticipant.getParticipantsByGroup(groupId);
	}
	
	public List<AttributeValues> getParticipantAttributes(Integer participantId){
		return iParticipant.getParticipantAttributes(participantId);
	}

}

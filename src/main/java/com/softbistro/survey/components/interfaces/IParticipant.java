package com.softbistro.survey.components.interfaces;

import java.util.List;

import com.softbistro.survey.components.entity.AttributeValues;
import com.softbistro.survey.components.entity.Participant;

public interface IParticipant {

	public Integer setParticipant(Participant participant);

	public List<Participant> getParticipantsByGroup(Integer groupId);

	public List<AttributeValues> getParticipantAttributesInGroup(Integer groupId, Integer participantId);

	public Integer updateParticipant(Participant participant);
	
	public Integer deleteParticipant(Integer participantId);
	
	public Participant getParticipantById(Integer participantId);
}

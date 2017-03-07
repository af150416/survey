package com.softbistro.survey.components.interfaces;

import java.util.List;

import com.softbistro.survey.components.entity.AttributeValues;
import com.softbistro.survey.components.entity.Participant;

public interface IParticipant {

	public Integer setParticipant(String firstName, String lastName, String email, String password);

	public List<Participant> getParticipantsByGroup(Integer groupId);

	public List<AttributeValues> getParticipantAttributesInGroup(Integer groupId, Integer participantId);

	public Integer updateParticipant(String firstName, String lastName, String email, String password);
	
	public void deleteParticipant(Integer participantId);
	
	public Participant getParticipantByEMail(String eMail);
}

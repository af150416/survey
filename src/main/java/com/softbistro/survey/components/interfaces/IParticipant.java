package com.softbistro.survey.components.interfaces;

import java.util.List;

import com.softbistro.survey.components.entity.AttributeValues;
import com.softbistro.survey.components.entity.Participant;

public interface IParticipant {

	public List<Participant> getParticipantsByGroup(Integer groupId);

	public List<AttributeValues> getParticipantAttributes(Integer participantId);
}

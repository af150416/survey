package com.softbistro.survey.components.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.softbistro.survey.components.entity.AttributeValues;
import com.softbistro.survey.components.entity.Participant;
import com.softbistro.survey.components.interfaces.IParticipant;

@Repository
public class ParticipantDao implements IParticipant {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private final String SQL_FOR_GETTING_PARTICIPANTS_BY_ID = "SELECT p.id, p.first_name, p.last_name, p.email, p.password, p.created_date, p.modified_date FROM survey.participant AS p left join survey.connect_group_participant AS c on c.participant_id = p.id WHERE c.group_id = ?";
	private final String SQL_FOR_GETTING_PARTICIPANT_ATTRIBUTES = "";

	@Override
	public List<Participant> getParticipantsByGroup(Integer groupId) {
		return (List<Participant>) jdbcTemplate.query(SQL_FOR_GETTING_PARTICIPANTS_BY_ID,
				new BeanPropertyRowMapper<>(Participant.class), groupId);
	}

	@Override
	public List<AttributeValues> getParticipantAttributes(Integer participantId) {
		return (List<AttributeValues>) jdbcTemplate.query(SQL_FOR_GETTING_PARTICIPANT_ATTRIBUTES,
				new BeanPropertyRowMapper<>(AttributeValues.class), participantId);
	}
}
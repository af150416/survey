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

	private final String SQL_FOR_GETTING_PARTICIPANTS_BY_GROUP_ID = "SELECT p.id, p.first_name, p.last_name, p.email, p.password, p.created_date, p.modified_date FROM survey.participant AS p left join survey.connect_group_participant AS c on c.participant_id = p.id WHERE c.group_id = ?";
	
	private final String SQL_FOR_GETTING_PARTICIPANT_ATTRIBUTES = "SELECT av.attribute_value FROM survey.attribute_values AS av LEFT JOIN survey.attributes AS a ON av.attribute_id=a.id LEFT JOIN survey.group AS g ON a.group_id=g.id LEFT JOIN survey.connect_group_participant AS c ON g.id=c.group_id AND c.participant_id=av.participant_id LEFT JOIN survey.participant AS p ON c.participant_id=p.id WHERE g.id= ? and p.id= ?";
	
	private final String SQL_FOR_SETTING_PARTICIPANT = "INSERT INTO survey.participant (survey.participant.first_name,survey.participant.last_name, survey.participant.email, survey.participant.password) VALUES (?,?,?,?)";
	
	private final String SQL_FOR_UPDATING_PARTICIPANT = "UPDATE survey.participant AS p SET p.first_name= ?, p.last_name= ?, p.email = ?, p.password= ? WHERE p.email= ?";
	
	private final String SQL_FOR_DELETING_PARTICIPANT = "DELETE p, c, av, a FROM survey.participant AS p INNER JOIN survey.connect_group_participant AS c ON p.id=c.participant_id INNER JOIN survey.attribute_values AS av ON p.id=av.participant_id INNER JOIN survey.answers AS a ON p.id=a.participant_id WHERE p.id= ?";
	
	private final String SQL_FOR_GETTING_PARTICIPANT_BY_ID = "SELECT * FROM survey.participant WHERE survey.participant.email= ?";

	

	@Override
	public List<Participant> getParticipantsByGroup(Integer groupId) {
		return (List<Participant>) jdbcTemplate.query(SQL_FOR_GETTING_PARTICIPANTS_BY_GROUP_ID,
				new BeanPropertyRowMapper<>(Participant.class), groupId);
	}

	@Override
	public List<AttributeValues> getParticipantAttributesInGroup(Integer groupId, Integer participantId) {
		return (List<AttributeValues>) jdbcTemplate.query(SQL_FOR_GETTING_PARTICIPANT_ATTRIBUTES,
				new BeanPropertyRowMapper<>(AttributeValues.class), groupId, participantId);
	}

	@Override
	public Integer setParticipant(String firstName, String lastName, String email, String password) {
		return jdbcTemplate.update(SQL_FOR_SETTING_PARTICIPANT, firstName, lastName, email, password);
	}

	@Override
	public Integer updateParticipant(String firstName, String lastName, String email, String password) {
		return jdbcTemplate.update(SQL_FOR_UPDATING_PARTICIPANT, firstName, lastName, email, password, email);
	}

	@Override
	public void deleteParticipant(Integer participantId) {
		jdbcTemplate.update(SQL_FOR_DELETING_PARTICIPANT, participantId);
	}

	@Override
	public Participant getParticipantByEMail(String eMail) {
		return (Participant) jdbcTemplate.query(SQL_FOR_GETTING_PARTICIPANT_BY_ID, new BeanPropertyRowMapper<>(Participant.class) ,eMail);
	}
}
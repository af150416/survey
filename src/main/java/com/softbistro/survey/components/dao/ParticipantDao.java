package com.softbistro.survey.components.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.softbistro.survey.components.entity.Participant;
import com.softbistro.survey.components.interfaces.IParticipant;


/**
 * Data access object for participant entity
 * @author af150416
 *
 */
@Repository
public class ParticipantDao implements IParticipant {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private final String SQL_FOR_GETTING_PARTICIPANTS_BY_GROUP_ID = "SELECT p.id, p.first_name, p.last_name, p.email, p.password, p.created_date, p.modified_date "
			+ "FROM survey.participant AS p left join survey.connect_group_participant AS c on c.participant_id = p.id WHERE c.group_id = ?";

	private final String SQL_FOR_SETTING_PARTICIPANT = "INSERT INTO survey.participant "
			+ "(survey.participant.first_name, survey.participant.last_name, survey.participant.email, survey.participant.password) VALUES (?, ?, ?, ?)";

	private final String SQL_FOR_UPDATING_PARTICIPANT = "UPDATE survey.participant AS p SET p.first_name= ?, p.last_name= ?, p.email = ?, p.password= ? WHERE p.id= ?";

	private final String SQL_FOR_DELETING_PARTICIPANT = "DELETE p, c, av, a FROM survey.participant AS p left join survey.connect_group_participant AS c on c.group_id=p.id "
			+ "left join survey.attribute_values AS av on av.participant_id=p.id left join survey.answers AS a on a.participant_id=p.id "
			+ "WHERE p.id= ?";

	private final String SQL_FOR_GETTING_PARTICIPANT_BY_ID = "SELECT * FROM survey.participant WHERE survey.participant.id= ?";

	/**
	 * Method for getting all participant by group
	 * @param groupId
	 * @return List<Participant>
	 */
	@Override
	public List<Participant> getParticipantsByGroup(Integer groupId) {
		return (List<Participant>) jdbcTemplate.query(SQL_FOR_GETTING_PARTICIPANTS_BY_GROUP_ID,
				new BeanPropertyRowMapper<>(Participant.class), groupId);
	}

	/**Method for creating participant 
	 * @param participant
	 * @return int status of method executing where (0 = Failed, 1 = Succeeded, 3 = Canceled, 5 = Unknown)
	 */
	@Override
	public Integer setParticipant(Participant participant) {
		return jdbcTemplate.update(SQL_FOR_SETTING_PARTICIPANT, participant.getFirstName(), participant.getLastName(), participant.geteMail(), participant.getPassword());
	}

	/**
	 * Method for updating participant
	 * @param participant
	 * @return int status of method executing where (0 = Failed, 1 = Succeeded, 3 = Canceled, 5 = Unknown)
	 */
	@Override
	public Integer updateParticipant(Participant participant) {
		return jdbcTemplate.update(SQL_FOR_UPDATING_PARTICIPANT, participant.getFirstName(), participant.getLastName(), participant.geteMail(), participant.getPassword(), participant.getId());
	}

	/**
	 * Method for deleting participant from db by id
	 * @param id
	 * @return int status of method executing where (0 = Failed, 1 = Succeeded, 3 = Canceled, 5 = Unknown)
	 */
	@Override
	public Integer deleteParticipant(Integer participantId) {
		return jdbcTemplate.update(SQL_FOR_DELETING_PARTICIPANT, participantId);
	}

	/**
	 * Method to getting  participant from db by id
	 * @param participantId
	 * @return Participant
	 */
	@Override
	public Participant getParticipantById(Integer participantId) {
		return (Participant) jdbcTemplate.queryForObject(SQL_FOR_GETTING_PARTICIPANT_BY_ID,
				new BeanPropertyRowMapper<>(Participant.class), participantId);
	}
}
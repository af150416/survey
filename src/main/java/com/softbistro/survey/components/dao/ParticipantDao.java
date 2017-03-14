package com.softbistro.survey.components.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.softbistro.survey.components.entity.ExecutingStatus;
import com.softbistro.survey.components.entity.Participant;
import com.softbistro.survey.components.interfaces.IParticipant;

/**
 * Data access object for participant entity
 * 
 * @author af150416
 *
 */
@Repository
public class ParticipantDao implements IParticipant {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private final static String SQL_FOR_SETTING_PARTICIPANT = "INSERT INTO survey.participant "
			+ "(survey.participant.first_name, survey.participant.last_name, survey.participant.email, survey.participant.password) VALUES (?, ?, ?, ?)";

	private final static String SQL_FOR_UPDATING_PARTICIPANT = "UPDATE survey.participant AS p SET p.first_name= ?, p.last_name= ?, p.email = ?, p.password= ? WHERE p.id= ?";

	private final static String SQL_FOR_DELETING_PARTICIPANT = "UPDATE survey.participant AS p left join survey.connect_group_participant AS c on c.group_id=p.id "
			+ "left join survey.attribute_values AS av on av.participant_id=p.id left join survey.answers AS a on a.participant_id=p.id "
			+ "SET p.status = 'DELETE', c.status = 'DELETE', av.status = 'DELETE', a.status = 'DELETE' WHERE p.email = ?";

	private final static String SQL_FOR_GETTING_PARTICIPANT_BY_ID = "SELECT * FROM survey.participant WHERE survey.participant.id= ?";

	private final static String SQL_FOR_CHECKING_THE_PARTICIPANT_EXISTING_BY_EMAIL = "SELECT COUNT(id) FROM survey.participant AS p WHERE p.email= ?";

	private final static String SQL_FOR_CHECKING_THE_PARTICIPANT_EXISTING_BY_ID = "SELECT COUNT(id) FROM survey.participant AS p WHERE p.id= ?";

	/**
	 * Method for creating participant
	 * 
	 * @param participant
	 * @return ExecutingStatus
	 */
	@Override
	public ExecutingStatus setParticipant(Participant participant) {
		if (jdbcTemplate.queryForObject(SQL_FOR_CHECKING_THE_PARTICIPANT_EXISTING_BY_EMAIL, Integer.class,
				participant.geteMail()) > 0) {
			return ExecutingStatus.ALREADY_EXIST;
		}
		int status = jdbcTemplate.update(SQL_FOR_SETTING_PARTICIPANT, participant.getFirstName(),
				participant.getLastName(), participant.geteMail(), participant.getPassword());
		if (status == 1) {
			return ExecutingStatus.SUCCEEDED;
		}
		return ExecutingStatus.FAILED;
	}

	/**
	 * Method for updating participant
	 * 
	 * @param participant
	 * @return ExecutingStatus
	 */
	@Override
	public ExecutingStatus updateParticipant(Participant participant) {
		if (jdbcTemplate.queryForObject(SQL_FOR_CHECKING_THE_PARTICIPANT_EXISTING_BY_EMAIL, Integer.class,
				participant.geteMail()) == 0) {
			return ExecutingStatus.NOT_EXIST;
		}
		int status = jdbcTemplate.update(SQL_FOR_UPDATING_PARTICIPANT, participant.getFirstName(),
				participant.getLastName(), participant.geteMail(), participant.getPassword(), participant.getId());
		if (status == 1) {
			return ExecutingStatus.SUCCEEDED;
		}
		return ExecutingStatus.FAILED;
	}

	/**
	 * Method for deleting participant from db by email
	 * 
	 * @param email
	 * @return ExecutingStatus
	 */
	@Override
	public ExecutingStatus deleteParticipant(String email) {
		if (jdbcTemplate.queryForObject(SQL_FOR_CHECKING_THE_PARTICIPANT_EXISTING_BY_EMAIL, Integer.class,
				email) == 0) {
			return ExecutingStatus.NOT_EXIST;
		}
		int status = jdbcTemplate.update(SQL_FOR_DELETING_PARTICIPANT, email);
		if (status == 1) {
			return ExecutingStatus.SUCCEEDED;
		}
		return ExecutingStatus.FAILED;
	}

	/**
	 * Method to getting participant from db by id
	 * 
	 * @param participantId
	 * @return Participant
	 */
	@Override
	public Participant getParticipantById(Integer participantId) {
		if (jdbcTemplate.queryForObject(SQL_FOR_CHECKING_THE_PARTICIPANT_EXISTING_BY_ID, Integer.class,
				participantId) == 0) {
			return new Participant();
		}
		return (Participant) jdbcTemplate.queryForObject(SQL_FOR_GETTING_PARTICIPANT_BY_ID,
				new BeanPropertyRowMapper<>(Participant.class), participantId);
	}
}
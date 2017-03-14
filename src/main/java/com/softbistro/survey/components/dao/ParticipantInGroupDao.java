package com.softbistro.survey.components.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.softbistro.survey.components.entity.ExecutingStatus;
import com.softbistro.survey.components.entity.Group;
import com.softbistro.survey.components.entity.Participant;
import com.softbistro.survey.components.entity.ParticipantInGroup;
import com.softbistro.survey.components.interfaces.IParticipantInGroup;

/**
 * Data access object for participant in group
 * 
 * @author af150416
 *
 */
@Repository
public class ParticipantInGroupDao implements IParticipantInGroup {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private final static String SQL_FOR_CHECKING_PARTICIPANT_EXISTING_IN_GROUP = "SELECT COUNT(*) FROM survey.connect_group_participant AS c WHERE c.group_id = ? AND c.participant_id = ?";
	private final static String SQL_FOR_ADDING_PARTICIPANT_IN_GROUP = "INSERT INTO survey.connect_group_participant (survey.connect_group_participant.group_id, survey.connect_group_participant.participant_id) VALUES (?, ?)";
	private final static String SQL_FOR_DELETING_PARTICIPANT_IN_GROUP = "SELECT * FROM survey.participant AS p LEFT JOIN survey.connect_group_participant AS c ON c.participant_id=p.id WHERE p.id= ?";
	private final static String SQL_FOR_GETTING_PARTICIPANTS_BY_GROUP_ID = "SELECT p.id, p.first_name, p.last_name, p.email, p.password, p.created_date, p.modified_date "
			+ "FROM survey.participant AS p left join survey.connect_group_participant AS c on c.participant_id = p.id WHERE c.group_id = ?";
	private final static String SQL_FOR_GETTING_PARTICIPANT_GROUPS = "SELECT * FROM survey.group AS g LEFT JOIN survey.connect_group_participant AS c ON g.id=c.group_id WHERE g.id = ?";

	/**
	 * Method for getting all participant by group
	 * 
	 * @param groupId
	 * @return List<Participant>
	 */
	@Override
	public List<Participant> getParticipantsByGroup(Integer groupId) {
		return (List<Participant>) jdbcTemplate.query(SQL_FOR_GETTING_PARTICIPANTS_BY_GROUP_ID,
				new BeanPropertyRowMapper<>(Participant.class), groupId);
	}

	/**
	 * Method for adding participant in group
	 * 
	 * @param groupId
	 * @param participantId
	 * @return ExecutingStatus
	 */
	@Override
	public ExecutingStatus addParticipantInGroup(ParticipantInGroup participantInGoup) {
		if ((jdbcTemplate.queryForObject(SQL_FOR_CHECKING_PARTICIPANT_EXISTING_IN_GROUP, Integer.class,
				participantInGoup.getGroupId(), participantInGoup.getParticipantId())) > 0) {
			return ExecutingStatus.ALREADY_EXIST;
		}
		if (jdbcTemplate.update(SQL_FOR_ADDING_PARTICIPANT_IN_GROUP, participantInGoup.getGroupId(),
				participantInGoup.getParticipantId()) == 1) {
			return ExecutingStatus.SUCCEEDED;
		}
		return ExecutingStatus.FAILED;
	}

	/**
	 * Method for deleting participant from group
	 * 
	 * @param groupId
	 * @param participantId
	 * @return ExecutingStatus
	 */
	@Override
	public ExecutingStatus deletingParticipantfromGroup(Integer groupId, Participant participantId) {
		if ((jdbcTemplate.queryForObject(SQL_FOR_CHECKING_PARTICIPANT_EXISTING_IN_GROUP, Integer.class, groupId,
				participantId)) == 0) {
			return ExecutingStatus.NOT_EXIST;
		}
		if (jdbcTemplate.update(SQL_FOR_DELETING_PARTICIPANT_IN_GROUP, groupId, participantId) == 1) {
			return ExecutingStatus.SUCCEEDED;
		}
		return ExecutingStatus.FAILED;
	}

	/**
	 * Method for getting all participant groups
	 * 
	 * @param participantId
	 * @return
	 */
	@Override
	public List<Group> getParticipantGroups(Integer participantId) {
		return (List<Group>) jdbcTemplate.query(SQL_FOR_GETTING_PARTICIPANT_GROUPS,
				new BeanPropertyRowMapper<>(Group.class), participantId);
	}
}

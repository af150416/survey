package com.softbistro.survey.components.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.softbistro.survey.components.entity.AttributeValues;
import com.softbistro.survey.components.entity.ExecutingStatus;
import com.softbistro.survey.components.interfaces.IAttributeValues;

/**
 * Data acces object for attribute values entity
 * @author af150416
 *
 */
@Repository
public class AttributeValuesDao implements IAttributeValues {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private final String SQL_FOR_SETTING_ATTRIBUTE_VALUES = "INSERT INTO survey.attribute_values "
			+ "(survey.attribute_values.attribute_id, survey.attribute_values.participant_id, survey.attribute_values.attribute_value) VALUES (?, ?, ?)";
	private final String SQL_FOR_GETTING_ATTRIBUTE_VALUES_BY_ID = "SELECT * FROM survey.attribute_values WHERE survey.attribute_values.id = ?";
	private final String SQL_FOR_UPDATING_ATTRIBUTE_VALUES_BY_ID = "UPDATE survey.attribute_values AS av SET av.attribute_value = ? WHERE av.id = ?";
	private final String SQL_FOR_DELETING_ATTRIBUTE_VALUES_BY_ID = "DELETE av FROM survey.attribute_values AS av WHERE av.id = ?";
	private final String SQL_FOR_GETTING_PARTICIPANT_ATTRIBUTES = "SELECT av.attribute_value FROM survey.attribute_values AS av "
			+ "LEFT JOIN survey.attributes AS a ON av.attribute_id=a.id LEFT JOIN survey.group AS g ON a.group_id=g.id "
			+ "LEFT JOIN survey.connect_group_participant AS c ON g.id=c.group_id AND c.participant_id=av.participant_id "
			+ "LEFT JOIN survey.participant AS p ON c.participant_id=p.id WHERE g.id= ? and p.id= ?";

	/**
	 * Method for creating attribute values
	 * @param attributeValues
	 * @return ExecutingStatus
	 */
	@Override
	public ExecutingStatus setAttributeValues(AttributeValues attributeValues) {
		int status =  jdbcTemplate.update(SQL_FOR_SETTING_ATTRIBUTE_VALUES, attributeValues.getAttributeId(), attributeValues.getParticipantId(), attributeValues.getValue());
		if (status==1){
		return ExecutingStatus.SUCCEEDED;
		}
		return ExecutingStatus.FAILED;
	}

	/**
	 * Method for getting attribute values form the db
	 * @param attributeValuesId
	 * @return AttributeValues
	 */
	@Override
	public AttributeValues getAttributeValuesById(Integer attributeValuesId) {
		return (AttributeValues) jdbcTemplate.queryForObject(SQL_FOR_GETTING_ATTRIBUTE_VALUES_BY_ID,
				new BeanPropertyRowMapper<>(AttributeValues.class), attributeValuesId);
	}

	/**
	 * Method for updating attribute values 
	 * @param attributeValues
	 * @return ExecutingStatus
	 */
	@Override
	public ExecutingStatus updateAttributeValuesById(AttributeValues attributeValues) {
		int status = jdbcTemplate.update(SQL_FOR_UPDATING_ATTRIBUTE_VALUES_BY_ID, attributeValues.getAttributeId(), attributeValues.getParticipantId(), attributeValues.getValue(), attributeValues.getId());
		if (status==1){
		return ExecutingStatus.SUCCEEDED;
		}
		return ExecutingStatus.FAILED;
	}

	/**
	 * Method for deleting attribute values by id
	 * @param attributeValuesId
	 * @return ExecutingStatus
	 */
	@Override
	public ExecutingStatus deleteAttributeValuesById(Integer attributeValuesId) {
		int status = jdbcTemplate.update(SQL_FOR_DELETING_ATTRIBUTE_VALUES_BY_ID, attributeValuesId);
		if (status==1){
		return ExecutingStatus.SUCCEEDED;
		}
		return ExecutingStatus.FAILED;
	}
	
	/**
	 * Method for getting all attribute values of participant in group
	 * @param groupId
	 * @param participantId
	 * @return List<AttributeValues>
	 */
	@Override
	public List<AttributeValues> getParticipantAttributesInGroup(Integer groupId, Integer participantId) {
		return (List<AttributeValues>) jdbcTemplate.query(SQL_FOR_GETTING_PARTICIPANT_ATTRIBUTES,
				new BeanPropertyRowMapper<>(AttributeValues.class), groupId, participantId);
	}
}

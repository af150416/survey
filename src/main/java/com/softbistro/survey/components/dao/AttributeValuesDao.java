package com.softbistro.survey.components.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.softbistro.survey.components.entity.AttributeValues;
import com.softbistro.survey.components.interfaces.IAttributeValues;

@Repository
public class AttributeValuesDao implements IAttributeValues {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private final String SQL_FOR_SETTING_ATTRIBUTE_VALUES = "INSERT INTO survey.attribute_values "
			+ "(survey.attribute_values.attribute_id, survey.attribute_values.participant_id, survey.attribute_values.attribute_value) VALUES (?, ?, ?)";
	private final String SQL_FOR_GETTING_ATTRIBUTE_VALUES_BY_ID = "SELECT * FROM survey.attribute_values WHERE survey.attribute_values.id = ?";
	private final String SQL_FOR_UPDATING_ATTRIBUTE_VALUES_BY_ID = "UPDATE survey.attribute_values AS av SET av.attribute_value = ? WHERE av.id = ?";
	private final String SQL_FOR_DELETING_ATTRIBUTE_VALUES_BY_ID = "DELETE av FROM survey.attribute_values AS av WHERE av.id = ?";

	@Override
	public Integer setAttributeValues(Integer attributeId, Integer participantId, String attributeValue) {
		return jdbcTemplate.update(SQL_FOR_SETTING_ATTRIBUTE_VALUES, attributeId, participantId, attributeValue);
	}

	@Override
	public AttributeValues getAttributeValuesById(Integer attributeValuesId) {
		return (AttributeValues) jdbcTemplate.query(SQL_FOR_GETTING_ATTRIBUTE_VALUES_BY_ID,
				new BeanPropertyRowMapper<>(AttributeValues.class), attributeValuesId);
	}

	@Override
	public Integer updateAttributeValuesById(Integer attributeValuesId, String attributeValue) {
		return jdbcTemplate.update(SQL_FOR_UPDATING_ATTRIBUTE_VALUES_BY_ID, attributeValuesId, attributeValue);
	}

	@Override
	public Integer deleteAttributeValuesById(Integer attributeValuesId) {
		return jdbcTemplate.update(SQL_FOR_DELETING_ATTRIBUTE_VALUES_BY_ID, attributeValuesId);
	}

}

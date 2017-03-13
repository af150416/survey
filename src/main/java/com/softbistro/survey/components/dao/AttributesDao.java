package com.softbistro.survey.components.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.softbistro.survey.components.entity.Attributes;
import com.softbistro.survey.components.interfaces.IAttributes;

/**
 * Data access object for attributes entity
 * @author af150416
 *
 */
@Repository
public class AttributesDao implements IAttributes {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private final String SQL_FOR_SETTING_ATTRIBUTES = "INSERT INTO survey.attributes (survey.attributes.group_id, survey.attributes.attribute) VALUES (?, ?)";
	private final String SQL_FOR_GETTING_ATTRIBUTES_BY_ID = "SELECT * FROM survey.attributes AS at WHERE at.id = ?";
	private final String SQL_FOR_UPDATING__ATTRIBUTES_BY_ID = "UPDATE survey.attributes AS at SET at.group_id = ?, at.attribute = ? WHERE at.id=?";
	private final String SQL_FOR_DELETING_ATTRIBUTES = "DELETE at, av FROM survey.attributes AS at LEFT JOIN survey.attribute_values AS av ON  av.attribute_id=at.id WHERE at.id = ?";
	private final String SQL_FOR_GETTING_ATTRIBUTES_BY_GROUP = "SELECT * FROM survey.attributes WHERE survey.attributes.group_id = ?";

	/**Method for creating the attribute value
	 * @param attributes
	 * @return int status of method executing where (0 = Failed, 1 = Succeeded, 3 = Canceled, 5 = Unknown)
	 */
	@Override
	public Integer setAttribute(Attributes attributes) {
		return jdbcTemplate.update(SQL_FOR_SETTING_ATTRIBUTES, attributes.getGroupId(), attributes.getAttribute());
	}

	/**
	 * Method for getting attribute by id
	 * @param attributesId
	 * @return Attributes
	 */
	@Override
	public Attributes getAttributeById(Integer attributesId) {
		return (Attributes) jdbcTemplate.queryForObject(SQL_FOR_GETTING_ATTRIBUTES_BY_ID,
				new BeanPropertyRowMapper<>(Attributes.class), attributesId);
	}

	/**
	 * Method for updating attribute
	 * @param attributes
	 * @return int status of method executing where (0 = Failed, 1 = Succeeded, 3 = Canceled, 5 = Unknown)
	 */
	@Override
	public Integer updateAttributes(Attributes attributes) {
		return jdbcTemplate.update(SQL_FOR_UPDATING__ATTRIBUTES_BY_ID,attributes.getGroupId(), attributes.getAttribute(), attributes.getId());
	}

	/**
	 * Method for deleting attributes by id
	 * @param attributesId
	 * @return int status of method executing where (0 = Failed, 1 = Succeeded, 3 = Canceled, 5 = Unknown)
	 */
	@Override
	public Integer deleteAttributes(Integer attributesId) {
		return jdbcTemplate.update(SQL_FOR_DELETING_ATTRIBUTES, attributesId);
	}

	/**
	 * Method to getting all attributes in group
	 * @param groupId
	 * @return List<Attributes>
	 */
	@Override
	public List<Attributes> getAttributesByGroup(Integer groupId) {
		return (List<Attributes>) jdbcTemplate.query(SQL_FOR_GETTING_ATTRIBUTES_BY_GROUP, new BeanPropertyRowMapper<>(Attributes.class), groupId);
	}
}

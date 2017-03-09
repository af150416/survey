package com.softbistro.survey.components.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.softbistro.survey.components.entity.Attributes;
import com.softbistro.survey.components.interfaces.IAttributes;

@Repository
public class AttributesDao implements IAttributes {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private final String SQL_FOR_SETTING_ATTRIBUTES = "INSERT INTO survey.attributes (survey.attributes.group_id, survey.attributes.attribute) VALUES (?, ?)";
	private final String SQL_FOR_GETTING_ATTRIBUTES_BY_ID = "SELECT at.id, at.group_id, at.attribute, at.created_date, at.modified_date FROM survey.attributes AS at WHERE at.id = ?";
	private final String SQL_FOR_UPDATING__ATTRIBUTES_BY_ID = "UPDATE survey.attributes AS at SET at.group_id = ?, at.attribute = ? WHERE at.id=?";
	private final String SQL_FOR_DELETING_ATTRIBUTES = "DELETE at, av FROM survey.attributes AS at INNER JOIN survey.attribute_values AS av ON av.attribute_id=at.id WHERE at.id = ?";
	private final String SQL_FOR_GETTING_ATTRIBUTES_BY_GROUP = "SELECT * FROM survey.attributes WHERE survey.attributes.group_id = ?";

	@Override
	public Integer setAttribute(Integer group_id, String attribute) {
		return jdbcTemplate.update(SQL_FOR_SETTING_ATTRIBUTES, group_id, attribute);
	}

	@Override
	public Attributes getAttributeById(Integer attributesId) {
		return (Attributes) jdbcTemplate.query(SQL_FOR_GETTING_ATTRIBUTES_BY_ID,
				new BeanPropertyRowMapper<>(Attributes.class), attributesId);
	}

	@Override
	public Integer updateAttributes(Integer attributeId, Integer groupId, String attribute) {
		return jdbcTemplate.update(SQL_FOR_UPDATING__ATTRIBUTES_BY_ID, attributeId, groupId, attribute);
	}

	@Override
	public Integer deleteAttributes(Integer attributesId) {
		return jdbcTemplate.update(SQL_FOR_DELETING_ATTRIBUTES, attributesId);
	}

	@Override
	public List<Attributes> getAttributesByGroup(Integer groupId) {
		return (List<Attributes>) jdbcTemplate.query(SQL_FOR_GETTING_ATTRIBUTES_BY_GROUP, new BeanPropertyRowMapper<>(Attributes.class), groupId);
	}

}

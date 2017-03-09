package com.softbistro.survey.components.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.softbistro.survey.components.entity.Group;
import com.softbistro.survey.components.interfaces.IGroup;

@Repository
public class GroupDao implements IGroup {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private final static String SQL_FOR_SETTING_GROUP = "INSERT INTO survey.group (survey.group.client_id, survey.group.group_name) VALUES (?, ?)";
	private final static String SQL_FOR_GETTING_GROUP_BY_ID = "SELECT g.id, g.client_id, g.group_name, g.created_date, g.modified_date FROM survey.group AS g WHERE g.id = ?";
	private final static String SQL_FOR_GETTING_GROUP_BY_CLIENT = "SELECT g.id, g.client_id, g.group_name, g.created_date, g.modified_date FROM survey.group AS g WHERE g.client_id = ?";
	private final static String SQL_FOR_UPDATING_GROUP_BY_ID = "UPDATE survey.group AS g SET g.group_name = ? WHERE g.id = ?";
	private final static String SQL_FOR_DELETING_GROUP_BY_ID = "DELETE g From survey.group AS g WHERE g.id = ?";

	@Override
	public Integer setGroup(Integer clientId, String groupName) {
		return jdbcTemplate.update(SQL_FOR_SETTING_GROUP, clientId, groupName);
	}

	@Override
	public Group getGroupByid(Integer groupId) {
		return (Group) jdbcTemplate.query(SQL_FOR_GETTING_GROUP_BY_ID, new BeanPropertyRowMapper<>(Group.class),
				groupId);
	}

	@Override
	public List<Group> getGroupsByClient(Integer clientId) {
		return (List<Group>) jdbcTemplate.query(SQL_FOR_GETTING_GROUP_BY_CLIENT,
				new BeanPropertyRowMapper<>(Group.class), clientId);
	}

	@Override
	public Integer updateGroupById(String groupName, Integer groupId) {
		return jdbcTemplate.update(SQL_FOR_UPDATING_GROUP_BY_ID, groupName, groupId);
	}

	@Override
	public Integer deleteGroupById(Integer groupId) {
		return jdbcTemplate.update(SQL_FOR_DELETING_GROUP_BY_ID, groupId);
	}
}

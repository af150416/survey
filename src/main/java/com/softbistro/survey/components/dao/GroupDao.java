package com.softbistro.survey.components.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.softbistro.survey.components.entity.Group;
import com.softbistro.survey.components.interfaces.IGroup;

/**
 * Data access object for group entity
 * @author af150416
 *
 */
@Repository
public class GroupDao implements IGroup {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private final static String SQL_FOR_SETTING_GROUP = "INSERT INTO survey.group (survey.group.client_id, survey.group.group_name) VALUES (?, ?)";
	private final static String SQL_FOR_GETTING_GROUP_BY_ID = "SELECT g.id, g.client_id, g.group_name, g.created_date, g.modified_date FROM survey.group AS g WHERE g.id = ?";
	private final static String SQL_FOR_GETTING_GROUP_BY_CLIENT = "SELECT g.id, g.client_id, g.group_name, g.created_date, g.modified_date FROM survey.group AS g WHERE g.client_id = ?";
	private final static String SQL_FOR_UPDATING_GROUP_BY_ID = "UPDATE survey.group AS g SET g.group_name = ? WHERE g.id = ?";
	private final static String SQL_FOR_DELETING_GROUP_BY_ID = "DELETE g, cp, cs, at, av From survey.group AS g LEFT JOIN survey.connect_group_participant AS cp ON cp.group_id=g.id "
			+ "LEFT JOIN survey.connect_group_survey AS cs ON cs.group_id=g.id LEFT JOIN survey.attributes AS at ON at.group_id=g.id "
			+ "LEFT JOIN survey.attribute_values AS av ON av.attribute_id=at.id WHERE g.id = ?";

	/**
	 * Method to create group
	 * @param group
	 * @return int status of method executing where (0 = Failed, 1 = Succeeded, 3 = Canceled, 5 = Unknown)
	 */
	@Override
	public Integer setGroup(Group group) {
		return jdbcTemplate.update(SQL_FOR_SETTING_GROUP, group.getClientId(), group.getGroupName());
	}
	
	/**
	 * Method to get group from db
	 * @param groupId
	 * @return Group
	 */
	@Override
	public Group getGroupByid(Integer groupId) {
		return (Group) jdbcTemplate.queryForObject(SQL_FOR_GETTING_GROUP_BY_ID, new BeanPropertyRowMapper<>(Group.class),
				groupId);
	}

	/**
	 * Method to get all clients in group
	 * @param clientId
	 * @return List<Group>
	 */
	@Override
	public List<Group> getGroupsByClient(Integer clientId) {
		return (List<Group>) jdbcTemplate.query(SQL_FOR_GETTING_GROUP_BY_CLIENT,
				new BeanPropertyRowMapper<>(Group.class), clientId);
	}

	/**
	 * Method to update group
	 * @param group
	 * @return int status of method executing where (0 = Failed, 1 = Succeeded, 3 = Canceled, 5 = Unknown)
	 */
	@Override
	public Integer updateGroupById(Group group) {
		return jdbcTemplate.update(SQL_FOR_UPDATING_GROUP_BY_ID, group.getClientId(), group.getGroupName(), group.getId());
	}

	/**
	 * Method for deleting group by id
	 * @param groupId
	 * @return int status of method executing where (0 = Failed, 1 = Succeeded, 3 = Canceled, 5 = Unknown)
	 */
	@Override
	public Integer deleteGroupById(Integer groupId) {
		return jdbcTemplate.update(SQL_FOR_DELETING_GROUP_BY_ID, groupId);
	}
}

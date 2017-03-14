package com.softbistro.survey.components.interfaces;

import java.util.List;

import com.softbistro.survey.components.entity.ExecutingStatus;
import com.softbistro.survey.components.entity.Group;

/**
 * Interface for Group entity
 * 
 * @author af150416
 *
 */
public interface IGroup {

	public ExecutingStatus setGroup(Group group);

	/**
	 * Method to create group
	 * 
	 * @param group
	 * @return ExecutingStatus
	 */
	public Group getGroupByid(Integer groupId);

	/**
	 * Method to get all clients in group
	 * 
	 * @param clientId
	 * @return List<Group>
	 */
	public List<Group> getGroupsByClient(Integer clientId);

	/**
	 * Method to update group
	 * 
	 * @param group
	 * @return ExecutingStatus
	 */
	public ExecutingStatus updateGroupById(Group group);

	/**
	 * Method for deleting group by id
	 * 
	 * @param groupId
	 * @return ExecutingStatus
	 */
	public ExecutingStatus deleteGroupById(Integer groupId);
}

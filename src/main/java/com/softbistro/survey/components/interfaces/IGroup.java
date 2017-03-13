package com.softbistro.survey.components.interfaces;

import java.util.List;

import com.softbistro.survey.components.entity.Group;

/**
 * @author af150416
 *
 */
public interface IGroup {

	public Integer setGroup(Group group);

	/**
	 * Method to create group
	 * @param group
	 * @return int status of method executing where (0 = Failed, 1 = Succeeded, 3 = Canceled, 5 = Unknown)
	 */
	public Group getGroupByid(Integer groupId);

	/**
	 * Method to get all clients in group
	 * @param clientId
	 * @return List<Group>
	 */
	public List<Group> getGroupsByClient(Integer clientId);

	/**
	 * Method to update group
	 * @param group
	 * @return int status of method executing where (0 = Failed, 1 = Succeeded, 3 = Canceled, 5 = Unknown)
	 */
	public Integer updateGroupById(Group group);

	/**
	 * Method for deleting group by id
	 * @param groupId
	 * @return int status of method executing where (0 = Failed, 1 = Succeeded, 3 = Canceled, 5 = Unknown)
	 */
	public Integer deleteGroupById(Integer groupId);
}

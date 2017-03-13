package com.softbistro.survey.components.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softbistro.survey.components.entity.Group;
import com.softbistro.survey.components.interfaces.IGroup;


/**
 * Service for group entity
 * @author af150416
 *
 */
@Service
public class GroupService {

	@Autowired
	IGroup iGroup;

	/**
	 * Method to create group
	 * @param group
	 * @return int status of method executing where (0 = Failed, 1 = Succeeded, 3 = Canceled, 5 = Unknown)
	 */
	public Integer setGroup(Group group) {
		return iGroup.setGroup(group);
	}

	/**
	 * Method to get group from db
	 * @param groupId
	 * @return Group
	 */
	public Group getGroupByid(Integer groupId) {
		return iGroup.getGroupByid(groupId);
	}

	/**
	 * Method to get all clients in group
	 * @param clientId
	 * @return List<Group>
	 */
	public List<Group> getGroupsByClient(Integer clientId) {
		return iGroup.getGroupsByClient(clientId);
	}

	/**
	 * Method to update group
	 * @param group
	 * @return int status of method executing where (0 = Failed, 1 = Succeeded, 3 = Canceled, 5 = Unknown)
	 */
	public Integer updateGroupById(Group group) {
		return iGroup.updateGroupById(group);
	}

	/**
	 * Method for deleting group by id
	 * @param groupId
	 * @return int status of method executing where (0 = Failed, 1 = Succeeded, 3 = Canceled, 5 = Unknown)
	 */
	public Integer deleteGroupById(Integer groupId) {
		return iGroup.deleteGroupById(groupId);
	}
}

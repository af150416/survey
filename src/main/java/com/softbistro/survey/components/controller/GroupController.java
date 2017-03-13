package com.softbistro.survey.components.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.softbistro.survey.components.entity.Group;
import com.softbistro.survey.components.service.GroupService;

/**
 * Controller for group entity
 * @author af150416
 *
 */
@RestController
@RequestMapping("/group")
public class GroupController {

	@Autowired
	GroupService groupService;

	/**
	 * Method to create group
	 * @param group
	 * @return int status of method executing where (0 = Failed, 1 = Succeeded, 3 = Canceled, 5 = Unknown)
	 */
	@RequestMapping(value = "/set", method = RequestMethod.PUT)
	public Integer setGroup(@RequestBody Group group) {
		return groupService.setGroup(group);
	}

	/**
	 * Method to get group from db
	 * @param groupId
	 * @return Group
	 */
	@RequestMapping(value = "/getById/{groupId}", method = RequestMethod.GET)
	public Group getGroupById(@PathVariable Integer groupId) {
		return groupService.getGroupByid(groupId);
	}

	/**
	 * Method to get all clients in group
	 * @param clientId
	 * @return List<Group>
	 */
	@RequestMapping(value = "/getByClient/{clientId}", method = RequestMethod.GET)
	public List<Group> getGroupByClient(@PathVariable Integer clientId) {
		return (List<Group>) groupService.getGroupsByClient(clientId);
	}

	/**
	 * Method to update group
	 * @param group
	 * @return int status of method executing where (0 = Failed, 1 = Succeeded, 3 = Canceled, 5 = Unknown)
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Integer updateGroup(@RequestBody Group group) {
		return groupService.updateGroupById(group);
	}

	/**
	 * Method for deleting group by id
	 * @param groupId
	 * @return int status of method executing where (0 = Failed, 1 = Succeeded, 3 = Canceled, 5 = Unknown)
	 */
	@RequestMapping(value = "/delete/{groupId}", method = RequestMethod.DELETE)
	public Integer deleteGroupById(@PathVariable Integer groupId) {
		return groupService.deleteGroupById(groupId);
	}
}

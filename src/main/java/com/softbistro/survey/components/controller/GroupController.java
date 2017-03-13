package com.softbistro.survey.components.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.softbistro.survey.components.entity.ExecutingStatus;
import com.softbistro.survey.components.entity.Group;
import com.softbistro.survey.components.entity.Participant;
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
	 * @return ExecutingStatus
	 */
	@RequestMapping(value = "/set", method = RequestMethod.PUT)
	 public ExecutingStatus setGroup(@RequestBody Group group) {
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
	 * @return ExecutingStatus
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	 public ExecutingStatus updateGroup(@RequestBody Group group) {
		return groupService.updateGroupById(group);
	}

	/**
	 * Method for deleting group by id
	 * @param groupId
	 * @return ExecutingStatus
	 */
	@RequestMapping(value = "/delete/{groupId}", method = RequestMethod.DELETE)
	 public ExecutingStatus deleteGroupById(@PathVariable Integer groupId) {
		return groupService.deleteGroupById(groupId);
	}
	
	/**
	 * Method for adding participant in group
	 * @param groupId
	 * @param participantId
	 * @return ExecutingStatus
	 */
	@RequestMapping(value = "/addParticipantInGroup/{groupId}/{participantId}", method = RequestMethod.PUT)
	public ExecutingStatus addParticipantInGroup(@PathVariable Integer groupId, Participant participantId){
		return groupService.addParticipantInGroup(groupId, participantId);
	}
}

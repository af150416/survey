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

@RestController
@RequestMapping("/group")
public class GroupController {

	@Autowired
	GroupService groupService;

	@RequestMapping(value = "/set", method = RequestMethod.PUT)
	public Integer setGroup(@RequestBody Integer clientId, String groupName) {
		return groupService.setGroup(clientId, groupName);
	}

	@RequestMapping(value = "/getById/{groupId}", method = RequestMethod.GET)
	public Group getGroupById(@PathVariable Integer groupId) {
		return groupService.getGroupByid(groupId);
	}

	@RequestMapping(value = "/getByClient/{clientId}", method = RequestMethod.GET)
	public List<Group> getGroupByClient(@PathVariable Integer clientId) {
		return (List<Group>) groupService.getGroupsByClient(clientId);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Integer updateGroup(@RequestBody Integer groupId, String groupName){
		return groupService.updateGroupById(groupId, groupName);
	}
	
	@RequestMapping(value = "/delete/{groupId}", method = RequestMethod.DELETE)
	public Integer deleteGroupById(@PathVariable Integer groupId ){
		return groupService.deleteGroupById(groupId);
	}
}

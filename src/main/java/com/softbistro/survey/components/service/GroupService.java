package com.softbistro.survey.components.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softbistro.survey.components.entity.Group;
import com.softbistro.survey.components.interfaces.IGroup;

@Service
public class GroupService {

	@Autowired
	IGroup iGroup;

	public Integer setGroup(Integer clientId, String groupName) {
		return iGroup.setGroup(clientId, groupName);
	}

	public Group getGroupByid(Integer groupId) {
		return iGroup.getGroupByid(groupId);
	}

	public List<Group> getGroupsByClient(Integer clientId) {
		return iGroup.getGroupsByClient(clientId);
	}

	public Integer updateGroupById(String groupName, Integer groupId) {
		return iGroup.updateGroupById(groupName, groupId);
	}

	public Integer deleteGroupById(Integer groupId) {
		return iGroup.deleteGroupById(groupId);
	}
}

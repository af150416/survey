package com.softbistro.survey.components.interfaces;

import java.util.List;

import com.softbistro.survey.components.entity.Group;

public interface IGroup {

	public Integer setGroup(Integer clientId, String groupName);

	public Group getGroupByid(Integer groupId);

	public List<Group> getGroupsByClient(Integer clientId);

	public Integer updateGroupById(String groupName, Integer groupId);

	public Integer deleteGroupById(Integer groupId);
}

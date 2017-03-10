package com.softbistro.survey.components.interfaces;

import java.util.List;

import com.softbistro.survey.components.entity.Group;

public interface IGroup {

	public Integer setGroup(Group group);

	public Group getGroupByid(Integer groupId);

	public List<Group> getGroupsByClient(Integer clientId);

	public Integer updateGroupById(Group group);

	public Integer deleteGroupById(Integer groupId);
}

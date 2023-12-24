package com.sylviealiceyoga.app.service;

import com.sylviealiceyoga.app.entity.Group;

import java.util.List;

public interface IGroupService
{
    List<Group> findAll();
    Group createGroup(Group group);
}

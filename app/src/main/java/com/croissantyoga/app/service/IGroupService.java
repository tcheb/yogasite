package com.croissantyoga.app.service;

import com.croissantyoga.app.entity.Group;

import java.util.List;

public interface IGroupService
{
    List<Group> findAll();
    Group createGroup(Group group);
}

package com.croissantyoga.app.db;

import java.util.List;

public interface IGroupService
{
    List<Group> findAll();
    Group createGroup(Group group);
}

package com.croissantyoga.app.service;

import com.croissantyoga.app.repository.IGroupRepository;
import com.croissantyoga.app.entity.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService implements IGroupService
{
    @Autowired
    private IGroupRepository repository;

    @Override
    public List<Group> findAll()
    {
        return (List<Group>) repository.findAll();
    }

    @Override
    public Group createGroup(Group group)
    {
        return repository.save(group);
    }
}

package com.sylviealiceyoga.app.service;

import com.sylviealiceyoga.app.repository.IGroupRepository;
import com.sylviealiceyoga.app.entity.Group;
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

package com.sylviealiceyoga.app.repository;

import com.sylviealiceyoga.app.entity.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGroupRepository extends CrudRepository<Group, Long>
{
}

package com.croissantyoga.app.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGroupRepository extends CrudRepository<Group, Long>
{
}

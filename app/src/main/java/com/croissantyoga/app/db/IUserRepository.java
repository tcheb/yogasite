package com.croissantyoga.app.db;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends CrudRepository<User, Long>
{
    List<User> findByUsername(String username);
}
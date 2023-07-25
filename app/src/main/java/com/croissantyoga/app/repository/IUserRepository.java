package com.croissantyoga.app.repository;


import com.croissantyoga.app.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends CrudRepository<User, Long>
{
    List<User> findByUsername(String username);
    List<User> findByEmail(String email);
}
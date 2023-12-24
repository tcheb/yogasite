package com.sylviealiceyoga.app.repository;


import com.sylviealiceyoga.app.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends CrudRepository<User, Long>
{
    List<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}
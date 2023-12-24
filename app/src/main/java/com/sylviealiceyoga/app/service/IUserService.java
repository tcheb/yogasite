package com.sylviealiceyoga.app.service;

import com.sylviealiceyoga.app.entity.User;

import java.util.List;

public interface IUserService
{
    List<User> findAll();
    User createUser(User user);
    List<User> findByUsername(String username);
}

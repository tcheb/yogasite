package com.croissantyoga.app.db;

import java.util.List;

public interface IUserService
{
    List<User> findAll();
    User createUser(User user);
    List<User> findByUsername(String username);
}

package com.croissantyoga.app.service;

import com.croissantyoga.app.repository.IUserRepository;
import com.croissantyoga.app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService
{
    @Autowired
    private IUserRepository repository;

    @Override
    public List<User> findAll()
    {
        return (List<User>) repository.findAll();
    }

    @Override
    public User createUser(User user)
    {
        return repository.save(user);
    }

    @Override
    public List<User> findByUsername(String username) {
        return repository.findByUsername(username);
    }
/*
    @Transactional(rollbackFor = Exception.class)
    public String saveDto(UserDto userDto) {
        userDto.setPassword(bCryptPasswordEncoder
                .encode(userDto.getPassword()));
        return save(new User(userDto)).getId();
    }

 */
}

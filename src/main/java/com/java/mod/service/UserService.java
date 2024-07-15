package com.java.mod.service;

import com.java.mod.mapper.UserMapper;
import com.java.mod.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    public User getUserByUserId(String userId) {
        return userMapper.getUserByUserId(userId);
    }

    public List<User> getAllUsers(){
        return userMapper.getAllUsers();
    }
    public User insertUser(User user) {
        int result = userMapper.insertUser(user);
        if (result > 0) {
            return user;
        }
        return null;
    }

    public boolean updateUser(User user) {
        return userMapper.updateUser(user) > 0;
    }

    public boolean deleteUser(String userId) {
        return userMapper.deleteUser(userId) > 0;
    }
}
package com.zpc.coderhome.service.impl;

import com.zpc.coderhome.dao.UserMapper;
import com.zpc.coderhome.model.User;
import com.zpc.coderhome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        return userMapper.selectByLogin(username,password);
    }

    @Override
    public User register(String name, String username, String password) {
        User user = new User();
        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);
        userMapper.insertSelective(user);
        return userMapper.selectByLogin(username,password);
    }
}

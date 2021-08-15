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
        if (userMapper.selectByLogin(username,password) == null){
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            userMapper.insertSelective(user);
            return userMapper.selectByLogin(username,password);
        }
        return null;
    }
}

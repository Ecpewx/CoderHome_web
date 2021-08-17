package com.zpc.coderhome.service.impl;

import com.zpc.coderhome.dao.UserInfoMapper;
import com.zpc.coderhome.dao.UserMapper;
import com.zpc.coderhome.model.User;
import com.zpc.coderhome.model.UserInfo;
import com.zpc.coderhome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo login(String username, String password) {
        UserInfo userInfo = userMapper.selectByLogin(username,password);
        return userMapper.selectByLogin(username,password);
    }

    @Override
    public UserInfo register(String name, String username, String password,String portiImage) {
        if (userMapper.selectByLogin(username,password) == null){
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            userMapper.insertSelective(user);
            UserInfo userInfo = userMapper.selectByLogin(username,password);
            System.out.println(userInfo.getId());
            userInfo.setName(name);
            userInfo.setPortiImage(portiImage);
            userInfoMapper.insert(userInfo);
            return userMapper.selectByLogin(username,password);
        }
        return null;
    }
}

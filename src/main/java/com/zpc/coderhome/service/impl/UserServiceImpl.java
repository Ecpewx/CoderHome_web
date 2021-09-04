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
    public UserInfo login(String uuid) {
        UserInfo userInfo = userMapper.selectByLogin(uuid);
        if (userInfo==null) {
            User user = new User();
            user.setUuid(uuid);
            userMapper.insertSelective(user);
            UserInfo userInfo1 = new UserInfo();
            userInfo1.setId(user.getId());
            userInfo1.setName("用户"+uuid.substring(0,6));
            userInfo1.setPortiImage("https://www.zjjpzxcz.com/coderhome/images/default_picture.jpg");
            userInfo1.setHistory("");
            userInfoMapper.insert(userInfo1);
            userInfo = userMapper.selectByLogin(uuid);
        }
        return userInfo;
    }
}

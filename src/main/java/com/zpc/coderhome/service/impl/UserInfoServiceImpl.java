package com.zpc.coderhome.service.impl;

import com.zpc.coderhome.dao.UserInfoMapper;
import com.zpc.coderhome.model.UserInfo;
import com.zpc.coderhome.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public UserInfo selectById(Integer id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }
}

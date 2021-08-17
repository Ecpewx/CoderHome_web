package com.zpc.coderhome.dao;

import com.zpc.coderhome.model.User;
import com.zpc.coderhome.model.UserInfo;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    UserInfo selectByLogin(String username, String password);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
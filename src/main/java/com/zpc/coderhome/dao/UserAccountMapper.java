package com.zpc.coderhome.dao;

import com.zpc.coderhome.model.UAcAndCode;
import com.zpc.coderhome.model.UserAccount;

public interface UserAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserAccount record);

    int insertSelective(UserAccount record);

    UserAccount selectByPrimaryKey(Integer id);
    UserAccount selectByUsername(String username);
    int updateByPrimaryKeySelective(UserAccount record);

    int updateByPrimaryKey(UserAccount record);
}
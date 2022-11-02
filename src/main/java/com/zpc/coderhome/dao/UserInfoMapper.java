package com.zpc.coderhome.dao;

import com.zpc.coderhome.model.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
    /**
     * 这个地方的foreignKey就是user_acid用于根据user_acid来进行搜索用户的info以及blog
     */
    UserInfo selectByForeignKey(Integer user_acid);
}
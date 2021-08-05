package com.zpc.coderhome.dao;

import com.zpc.coderhome.model.Intro;

public interface IntroMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Intro record);

    int insertSelective(Intro record);

    Intro selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Intro record);

    int updateByPrimaryKeyWithBLOBs(Intro record);
}
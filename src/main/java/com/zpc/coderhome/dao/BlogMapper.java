package com.zpc.coderhome.dao;

import com.zpc.coderhome.model.Blog;

import java.util.List;

public interface BlogMapper {
    int deleteByPrimaryKey(Integer id,Integer authorId);

    int insert(Blog record);

    int insertSelective(Blog record);

    Blog selectByPrimaryKey(Integer id);

    List<Blog> selectByUserId(Integer id);

    List<Blog> selectAll();

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKeyWithBLOBs(Blog record);

    int updateByPrimaryKey(Blog record);
}
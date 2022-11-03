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

    /**
     * 分页查询
     * @param userid
     * @return
     */
    List<Blog> selectByUserId_web(Integer userid,Integer bias,Integer pageSize);
    List<Blog> selectByUseridAndCa(Integer userid,Integer ca,Integer bias,Integer pageSize);
    List<Blog> selectByCategory(Integer categoryId);
    Integer selectCountByUserid(Integer userid);
    Integer selectCountByUseridAndCa(Integer userid,Integer ca);
    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKeyWithBLOBs(Blog record);

    int updateByPrimaryKey(Blog record);

}
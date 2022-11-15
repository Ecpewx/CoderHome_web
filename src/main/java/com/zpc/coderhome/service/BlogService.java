package com.zpc.coderhome.service;

import com.zpc.coderhome.model.Blog;

import java.util.List;

public interface BlogService {

    int delete(Integer id, Integer authorId);
    int deleteById(Integer id);
    List<Blog> selectAll(String category);
/**
 * 该userId并不是真正的userid,而是blog的id
 */

    List<Blog> selectByUserId(Integer id);


    List<Blog> selectByUseridAndCa(Integer userid,Integer ca ,Integer bias,Integer pageSize);

    Integer selectTotalBlogNum(Integer userid,Integer ca );
    Blog selectById(Integer id);

    int insertBlog(Blog blog);
}

package com.zpc.coderhome.service;

import com.zpc.coderhome.model.Blog;

import java.util.List;

public interface BlogService {

    int delete(Integer id, Integer authorId);

    List<Blog> selectAll();

    List<Blog> selectByUserId(Integer id);

    int insertBlog(Blog blog);
}

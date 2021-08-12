package com.zpc.coderhome.service.impl;

import com.zpc.coderhome.dao.BlogMapper;
import com.zpc.coderhome.model.Blog;
import com.zpc.coderhome.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public int delete(Integer id, Integer authorId) {
        return blogMapper.deleteByPrimaryKey(id,authorId);
    }

    @Override
    public List<Blog> selectAll(String category) {
        if (!category.isEmpty()){
            return blogMapper.selectByCategory(Integer.valueOf(category));
        }else{
            return blogMapper.selectAll();
        }
    }

    @Override
    public List<Blog> selectByUserId(Integer id) {
        return blogMapper.selectByUserId(id);
    }

    @Override
    public int insertBlog(Blog blog) {
        return blogMapper.insertSelective(blog);
    }
}

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
    /**
     * 分页查询所有的文章，以userid和ca作为查询
     * @param userid
     * 用户id
     * @param ca
     * 文章类型
     * @param bias
     * 偏移量
     * @param pageSize
     * 每页显示多少数据
     * @return
     */
    @Override
    public List<Blog> selectByUseridAndCa(Integer userid, Integer ca,Integer bias,Integer pageSize) {
        if(ca==0){
            return  blogMapper.selectByUserId_web(userid,bias,pageSize);
        }
        else{
            return blogMapper.selectByUseridAndCa(userid,ca,bias,pageSize);
        }
    }

    @Override
    public Integer selectTotalBlogNum(Integer userid, Integer ca) {
        if(ca!=0)return blogMapper.selectCountByUseridAndCa(userid,ca);
        else
            return blogMapper.selectCountByUserid(userid);
    }

    @Override
    public Blog selectById(Integer id) {
        return blogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertBlog(Blog blog) {
        return blogMapper.insertSelective(blog);
    }
}

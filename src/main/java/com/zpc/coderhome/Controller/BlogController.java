package com.zpc.coderhome.Controller;

import com.zpc.coderhome.model.Blog;
import com.zpc.coderhome.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    BlogService blogService;

    @RequestMapping("/delete_blog")
    public @ResponseBody String deleteBlog(String id, String authorId){
        return  String.valueOf(blogService.delete(Integer.valueOf(id), Integer.valueOf(authorId)));
    }

    @RequestMapping("/all_blog")
    public @ResponseBody List<Blog> allBlog(String category){
        System.out.println(category);
        return blogService.selectAll(category);
    }

    @RequestMapping("/user_blog")
    public @ResponseBody List<Blog> userBlog(String id){
        return blogService.selectByUserId(Integer.valueOf(id));
    }

    @RequestMapping("/insert_blog")
    public @ResponseBody String insertBlog(Blog blog){
        return String.valueOf(blogService.insertBlog(blog));
    }
}

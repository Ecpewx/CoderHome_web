package com.zpc.coderhome.Controller;

import com.zpc.coderhome.model.Blog;
import com.zpc.coderhome.service.BlogService;
import com.zpc.coderhome.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class BlogController {

    @Autowired
    FileService fileService;

    @Autowired
    BlogService blogService;

    @RequestMapping(value = "/delete_blog",method = RequestMethod.POST)
    public @ResponseBody String deleteBlog(String id, String authorId){
        return  String.valueOf(blogService.delete(Integer.valueOf(id), Integer.valueOf(authorId)));
    }

    @RequestMapping("/all_blog")
    public @ResponseBody List<Blog> allBlog(HttpServletResponse response, String category){
        response.setCharacterEncoding("utf-8");
        return blogService.selectAll(category);
    }

    @RequestMapping("/user_blog")
    public @ResponseBody List<Blog> userBlog(String id){
        return blogService.selectByUserId(Integer.valueOf(id));
    }

    @RequestMapping(value = "/insert_blog",method = RequestMethod.POST)
    public @ResponseBody String insertBlog(Blog blog){
        System.out.println("categoryId:"+blog.getCategoryId()+";introImage:"+blog.getIntroImage());
        return String.valueOf(blogService.insertBlog(blog));
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public @ResponseBody String fileUpload(MultipartFile file) throws IOException {
        if (file == null){
            return "fail";
        }
        String staticPath = ClassUtils.getDefaultClassLoader().getResource("static").getPath();
        String name = file.getOriginalFilename();
        String urlName = "images" + File.separator + name;
        String savePath = staticPath + File.separator + urlName;
        String visitPath = "images/"+name;
        File iFile = new File(savePath);
        if (!iFile.exists()){
            file.transferTo(iFile);
            fileService.upload(name,savePath);
            return visitPath;
        }
        return "no";
    }
}

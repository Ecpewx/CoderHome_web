package com.zpc.coderhome.Controller;

import com.zpc.coderhome.model.User;
import com.zpc.coderhome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class EntranceController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public @ResponseBody User login(String username, String password){
        System.out.println("username:"+username+",password:"+password);
        return userService.login(username,password);
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public @ResponseBody User register(String name,String username,String password){
        return userService.register(name,username,password);
    }
}

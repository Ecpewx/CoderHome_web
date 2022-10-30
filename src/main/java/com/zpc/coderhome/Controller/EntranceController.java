package com.zpc.coderhome.Controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zpc.coderhome.model.UAcAndCode;
import com.zpc.coderhome.model.UserInfo;
import com.zpc.coderhome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@CrossOrigin
public class EntranceController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public @ResponseBody
    UserInfo login(String uuid) {
//        System.out.println("user:"+uuid+" login...");
        return userService.login(uuid);
    }
    @RequestMapping("/login_web")
    public @ResponseBody
    UAcAndCode login_web(String username, String password){
        return userService.login_web(username,password);
    }
    @RequestMapping("/register_web")
    public @ResponseBody Integer register_web(String username,String password){
        return userService.register_web(username,password);
    }
    @RequestMapping("/username_check")
    public @ResponseBody Boolean usernameCheck(String username){
        return userService.username_check(username);
    }
}

package com.zpc.coderhome.Controller;

import com.zpc.coderhome.model.UAcAndCode;
import com.zpc.coderhome.model.UserInfo;
import com.zpc.coderhome.service.BlogService;
import com.zpc.coderhome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@CrossOrigin
public class EntranceController {

    @Autowired
    private UserService userService;
    @Autowired
   private BlogService blogService;
    @RequestMapping("/login")
    public @ResponseBody
    UserInfo login(String uuid) {
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
    /**
     * 没有找到对应的username就返回TRUE，否则返回FALSE
     * */
    @RequestMapping( "/username_check")
    public @ResponseBody Boolean usernameCheck(String username){
        return userService.username_check(username);
    }
    @RequestMapping("/showUserInfo")
    public @ResponseBody UserInfo showUserInfo(Integer user_acid){
        System.out.println(user_acid);
        return userService.showUserInfo(user_acid);
    }

}

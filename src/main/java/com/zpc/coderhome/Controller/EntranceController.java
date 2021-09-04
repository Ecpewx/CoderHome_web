package com.zpc.coderhome.Controller;

import com.zpc.coderhome.model.UserInfo;
import com.zpc.coderhome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class EntranceController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public @ResponseBody
    UserInfo login(String uuid) {
        System.out.println("user:"+uuid+" login...");
        return userService.login(uuid);
    }
}

package com.zpc.coderhome.service;

import com.zpc.coderhome.model.UAcAndCode;
import com.zpc.coderhome.model.UserInfo;

public interface UserService {
//手机端登录
    UserInfo login(String uuid);
    //网页端登录
    UAcAndCode login_web(String username, String password);
    //网页端注册
    Integer register_web(String username ,String password);
//    UserInfo login_account(String username,String pasaword);
    Boolean username_check(String username);
    UserInfo showUserInfo(Integer user_acid);
}

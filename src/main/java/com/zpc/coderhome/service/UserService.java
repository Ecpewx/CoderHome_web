package com.zpc.coderhome.service;

import com.zpc.coderhome.model.UserInfo;

public interface UserService {

    UserInfo login(String username, String password);

    UserInfo register(String name, String username, String password,String portiImage);
}

package com.zpc.coderhome.service;

import com.zpc.coderhome.model.User;

public interface UserService {

    User login(String username, String password);

    User register(String name, String username, String password);
}

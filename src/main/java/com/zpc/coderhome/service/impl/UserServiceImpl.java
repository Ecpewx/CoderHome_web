package com.zpc.coderhome.service.impl;

import com.zpc.coderhome.dao.UserAccountMapper;
import com.zpc.coderhome.dao.UserInfoMapper;
import com.zpc.coderhome.dao.UserMapper;
import com.zpc.coderhome.model.UAcAndCode;
import com.zpc.coderhome.model.User;
import com.zpc.coderhome.model.UserAccount;
import com.zpc.coderhome.model.UserInfo;
import com.zpc.coderhome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserAccountMapper userAccountMapper;

    @Override
    //手机端登录(uuid标识)
    public UserInfo login(String uuid) {
        UserInfo userInfo = userMapper.selectByLogin(uuid);
        if (userInfo==null) {
            User user = new User();
            user.setUuid(uuid);
            userMapper.insertSelective(user);
            UserInfo userInfo1 = new UserInfo();
            userInfo1.setId(user.getId());
            userInfo1.setName("用户"+uuid.substring(0,6));
            userInfo1.setPortiImage("https://www.zjjpzxcz.com/coderhome/images/default_picture.jpg");
            userInfo1.setHistory("");
            userInfoMapper.insert(userInfo1);
            userInfo = userMapper.selectByLogin(uuid);
        }
        return userInfo;
    }

    @Override
/**
 * 网页端登录
 * 当返回值为404时，为不存在该用户
 * 当返回值为-1时，为密码输入错误
 * 其他情况返回user_info的id
 *
 */
//网页端账号密码登录
    public UAcAndCode login_web(String username, String password) {
        UserAccount ua =userAccountMapper.selectByUsername(username);
        UAcAndCode userAndCode=new UAcAndCode();
        if(ua== null){
            userAndCode.setCode(404);
            userAndCode.setUserAccount(ua);
        }
        else if(!ua.getPassword().equals(password)){
            userAndCode.setCode(-1);
            userAndCode.setUserAccount(null);
        }
        else{
            userAndCode.setCode(0);
            userAndCode.setUserAccount(ua);
        }


        return userAndCode;
    }
    @Override
    /**
     *网页端注册(账号密码登录)
     */
    public Integer register_web(String username, String password) {
        UserAccount ua= new UserAccount();
        ua.setUsername(username);
        ua.setPassword(password);
        userAccountMapper.insert(ua);
        ua =userAccountMapper.selectByUsername(username);
        UserInfo userInfo = new UserInfo();
        userInfo.setName(username);
        userInfo.setPortiImage("https://www.zjjpzxcz.com/coderhome/images/default_picture.jpg");
        userInfo.setHistory("");
        userInfo.setUserAcid(ua.getId());

        return userInfoMapper.insert(userInfo);
    }

    /**注册时检查有没有用户名重复
     *
     * @param username
     * @return
     */
    @Override
    public Boolean username_check(String username) {
        UserAccount ua=userAccountMapper.selectByUsername(username);
        return  ua==null?Boolean.TRUE:Boolean.FALSE;
    }

    @Override
    public UserInfo showUserInfo(Integer user_acid) {
        return userInfoMapper.selectByForeignKey(user_acid);
    }
}

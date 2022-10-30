package com.zpc.coderhome.model;
/**
 * 网页端登录
 * 当返回值为404时，为不存在该用户
 * 当返回值为-1时，为密码输入错误
 * 其他情况返回user_info的id
 *
 */
public class UAcAndCode {


    public UAcAndCode(UserAccount userAccount, Integer code) {
        this.userAccount = userAccount;
        this.code = code;
    }

    public UAcAndCode() {
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    private UserAccount userAccount;
    private Integer code;
}

package com.hz.admin.model.request.login;

import com.dzzh.hz.hzsf.common.pojo.CommonPojo;

/**
 * @Classname LoginRequest
 * @Description TODO
 * @Date 2020-04-30 16:45
 * @Created by hzong
 */
public class LoginRequest extends CommonPojo {
    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    private String pwd;
    /**
     * 记录密码
     */
    private Boolean rememberMe;
    /**
     * 验证码
     */
    private String verifyCode;

    public Boolean getRememberMe() {
        return rememberMe;
    }

    public LoginRequest setRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
        return this;
    }

    public String getAccount() {
        return account;
    }

    public LoginRequest setAccount(String account) {
        this.account = account;
        return this;
    }

    public String getPwd() {
        return pwd;
    }

    public LoginRequest setPwd(String pwd) {
        this.pwd = pwd;
        return this;
    }
}

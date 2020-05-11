package com.hz.admin.model.pojo.dto.login;

import com.hz.hzsf.common.pojo.CommonPojo;

/**
 * @Classname LoginDTO
 * @Description TODO
 * @Date 2020-04-30 16:45
 * @Created by hzong
 */
public class LoginDTO extends CommonPojo {
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

    public LoginDTO setRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
        return this;
    }

    public String getAccount() {
        return account;
    }

    public LoginDTO setAccount(String account) {
        this.account = account;
        return this;
    }

    public String getPwd() {
        return pwd;
    }

    public LoginDTO setPwd(String pwd) {
        this.pwd = pwd;
        return this;
    }
}

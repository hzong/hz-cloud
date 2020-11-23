package com.hz.admin.pojo.bo.login;

/**
 * @Classname LoginBO
 * @Description TODO
 * @Date 2020-06-28 21:39
 * @Created by hzong
 */
public class LoginBO {

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

    public String getAccount() {
        return account;
    }

    public LoginBO setAccount(String account) {
        this.account = account;
        return this;
    }

    public String getPwd() {
        return pwd;
    }

    public LoginBO setPwd(String pwd) {
        this.pwd = pwd;
        return this;
    }

    public Boolean getRememberMe() {
        return rememberMe;
    }

    public LoginBO setRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
        return this;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public LoginBO setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
        return this;
    }
}

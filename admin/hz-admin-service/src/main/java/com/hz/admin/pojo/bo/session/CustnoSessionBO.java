package com.hz.admin.pojo.bo.session;

import com.dzzh.hz.hzsf.common.pojo.CommonPojo;

/**
 * @Classname CustnoSessionBO
 * @Description TODO
 * @Date 2020-07-28 22:31
 * @Created by hzong
 */
public class CustnoSessionBO extends CommonPojo {
    /**
     * 账号
     */
    private String account;
    /**
     * 会员编码
     */
    private String custno;
    /**
     * 昵称
     */
    private String nick;

    /**
     * 角色
     */
    private Integer role;


    public String getAccount() {
        return account;
    }

    public CustnoSessionBO setAccount(String account) {
        this.account = account;
        return this;
    }

    public String getCustno() {
        return custno;
    }

    public CustnoSessionBO setCustno(String custno) {
        this.custno = custno;
        return this;
    }

    public String getNick() {
        return nick;
    }

    public Integer getRole() {
        return role;
    }

    public CustnoSessionBO setRole(Integer role) {
        this.role = role;
        return this;
    }

    public CustnoSessionBO setNick(String nick) {
        this.nick = nick;
        return this;
    }
}

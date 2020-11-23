package com.hz.admin.db.entity.ex;

import com.dzzh.hz.hzsf.common.pojo.CommonPojo;

/**
 * @Classname AccountCustnoInfoDO
 * @Description TODO
 * @Date 2020-07-15 23:16
 * @Created by hzong
 */
public class AccountCustnoInfoDO extends CommonPojo {
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

    public AccountCustnoInfoDO setAccount(String account) {
        this.account = account;
        return this;
    }

    public String getCustno() {
        return custno;
    }

    public AccountCustnoInfoDO setCustno(String custno) {
        this.custno = custno;
        return this;
    }

    public String getNick() {
        return nick;
    }

    public Integer getRole() {
        return role;
    }

    public AccountCustnoInfoDO setRole(Integer role) {
        this.role = role;
        return this;
    }

    public AccountCustnoInfoDO setNick(String nick) {
        this.nick = nick;
        return this;
    }
}

package com.hz.admin.pojo.bo.session;

import com.dzzh.hz.hzsf.common.pojo.CommonPojo;

/**
 * @Classname SessionInfoBO
 * @Description TODO
 * @Date 2020-07-28 22:35
 * @Created by hzong
 */
public class SessionInfoBO extends CommonPojo {

    /**
     * 会员编码
     */
    private String custno;

    /**
     * 会员SO
     */
    private CustnoSessionBO custnoSession;

    public CustnoSessionBO getCustnoSession() {
        return custnoSession;
    }

    public SessionInfoBO setCustnoSession(CustnoSessionBO custnoSession) {
        this.custnoSession = custnoSession;
        return this;
    }

    public String getCustno() {
        return custno;
    }

    public SessionInfoBO setCustno(String custno) {
        this.custno = custno;
        return this;
    }
}

package com.hz.admin.utils;

import com.hz.admin.pojo.bo.session.SessionInfoBO;
import com.hz.admin.pojo.bo.session.CustnoSessionBO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * @Classname SessionUtil
 * @Description TODO
 * @Date 2020-08-02 22:42
 * @Created by hzong
 */
public class SessionUtil {
    private SessionUtil() {
    }



    public static SessionInfoBO getSession(){
        Subject subject = SecurityUtils.getSubject();
        SessionInfoBO session = (SessionInfoBO) subject.getPrincipal();
        return session;
    }

    public static String getSessionCustno(){
        Subject subject = SecurityUtils.getSubject();
        SessionInfoBO session = (SessionInfoBO) subject.getPrincipal();
        return session.getCustno();
    }

    public static CustnoSessionBO getCustnoSession(){
        Subject subject = SecurityUtils.getSubject();
        SessionInfoBO session = (SessionInfoBO) subject.getPrincipal();
        return session.getCustnoSession();
    }



}

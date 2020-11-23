package com.hz.admin.service.login;

import com.hz.admin.model.request.login.LoginRequest;
import com.dzzh.hz.hzsf.common.pojo.dto.common.ResponseDTO;

/**
 * @Classname LoginService
 * @Description TODO
 * @Date 2020-04-12 16:27
 * @Created by hzong
 */
public interface LoginService {

    /**
     * 登录
     * @return
     */
     ResponseDTO loginAuth(LoginRequest request);

}

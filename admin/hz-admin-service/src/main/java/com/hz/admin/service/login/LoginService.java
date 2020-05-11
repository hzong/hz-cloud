package com.hz.admin.service.login;

import com.hz.admin.model.pojo.dto.login.LoginDTO;
import com.hz.hzsf.common.pojo.result.ServerResult;

/**
 * @Classname LoginService
 * @Description TODO
 * @Date 2020-04-12 16:27
 * @Created by hzong
 */
public interface LoginService {

    /**
     * 登录
     * @param dto
     * @return
     */
     ServerResult login(LoginDTO dto);

}

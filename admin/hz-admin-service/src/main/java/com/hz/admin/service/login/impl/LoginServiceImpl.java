package com.hz.admin.service.login.impl;

import com.dzzh.hz.hzsf.common.pojo.dto.common.ResponseDTO;
import com.hz.admin.constant.FieldConstant;
import com.hz.admin.model.request.login.LoginRequest;
import com.hz.admin.service.login.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname LoginServiceImpl
 * @Description TODO
 * @Date 2020-04-12 16:27
 * @Created by hzong
 */
@Service
public class LoginServiceImpl implements LoginService {




    @Override
    public ResponseDTO loginAuth(LoginRequest loginRequest){

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(loginRequest.getAccount(), loginRequest.getAccount()+loginRequest.getPwd());
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            return ResponseDTO.fail(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return ResponseDTO.fail(e.getMessage());
        } catch (LockedAccountException e) {
            return ResponseDTO.fail(e.getMessage());
        } catch (AuthenticationException e) {
            return ResponseDTO.fail("认证失败！");
        }

        Map<String,Object> result = new HashMap<>(2);
        result.put(FieldConstant.TOKEN,subject.getSession().getId());
        result.put(FieldConstant.INFO,subject.getPrincipal());
        return ResponseDTO.ok(result);
    }




}

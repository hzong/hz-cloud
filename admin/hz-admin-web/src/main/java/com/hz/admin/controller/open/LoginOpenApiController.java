package com.hz.admin.controller.open;

import com.dzzh.hz.hzsf.common.pojo.dto.common.ResponseDTO;
import com.hz.admin.pojo.bo.login.LoginBO;
import com.hz.admin.service.login.LoginService;
import com.hz.admin.controller.base.BaseController;
import com.hz.admin.model.request.login.LoginRequest;
import com.dzzh.hz.hzsf.common.encrypt.Md5Encrypt;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


/**
 * 免登陆请求控制器，用于访问首页之类的请求
 *
 * @author ShengHao
 *
 */
@RestController
public class LoginOpenApiController extends BaseController {


    @Autowired
    private LoginService loginService;



    @PostMapping("/login/auth")
    public ResponseDTO login(@RequestBody  String json) {
        LoginRequest dto = parseJson(json, LoginRequest.class);
        return loginService.loginAuth(dto);
    }




    @PostMapping("/login/rememberMe")
    public ResponseDTO loginRememberMe(@RequestBody  String json) {
        LoginRequest dto = parseJson(json, LoginRequest.class);

        // 密码MD5加密
        String sign = Md5Encrypt.encodeByMD5(dto.getAccount()+dto.getPwd());
        UsernamePasswordToken token = new UsernamePasswordToken(dto.getAccount(), sign,dto.getRememberMe());
        return loginAuth(dto,token);
    }

    /**
     * 登录处理
     * @param dto
     * @param token
     * @return
     */
    private ResponseDTO loginAuth(LoginRequest dto, UsernamePasswordToken token) {
        // 获取Subject对象
        Subject subject = SecurityUtils.getSubject();
        LoginBO loginBo = new LoginBO();
        try {
            subject.login(token);
            BeanUtils.copyProperties(dto,loginBo);
        } catch (UnknownAccountException e) {
            return ResponseDTO.fail(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return ResponseDTO.fail(e.getMessage());
        } catch (LockedAccountException e) {
            return ResponseDTO.fail(e.getMessage());
        } catch (AuthenticationException e) {
            return ResponseDTO.fail("认证失败！");
        }
//        return loginService.login(loginBo);
        return null;
    }

    @PostMapping("/logout")

    public ResponseDTO logout(HttpServletResponse response) {
        Subject lvSubject = SecurityUtils.getSubject();
        if(lvSubject != null){
            lvSubject.logout();
        }
        return ResponseDTO.ok();
    }

}

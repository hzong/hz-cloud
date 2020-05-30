package com.hz.admin.controller.open;

import com.hz.admin.controller.base.BaseController;
import com.hz.admin.model.pojo.dto.login.LoginDTO;
import com.hz.admin.service.login.LoginService;
import com.hz.admin.web.common.constants.UrlConstants;
import com.hz.hzsf.common.encrypt.Md5Encrypt;
import com.hz.hzsf.common.pojo.result.ServerResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
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

    public ServerResult login(@RequestBody  String json) {
        LoginDTO dto = parseJson(json,LoginDTO.class);

        // 密码MD5加密
        String sign = Md5Encrypt.encodeByMD5(dto.getAccount()+dto.getPwd());
        UsernamePasswordToken token = new UsernamePasswordToken(dto.getAccount(), sign);
        // 获取Subject对象
        return loginHandle(dto,token);
    }


    @PostMapping("/login/rememberMe")

    public ServerResult loginRememberMe(@RequestBody  String json) {
        LoginDTO dto = parseJson(json,LoginDTO.class);


        // 密码MD5加密
        String sign = Md5Encrypt.encodeByMD5(dto.getAccount()+dto.getPwd());
        UsernamePasswordToken token = new UsernamePasswordToken(dto.getAccount(), sign,dto.getRememberMe());
        return loginHandle(dto,token);
    }

    /**
     * 登录处理
     * @param dto
     * @param token
     * @return
     */
    private ServerResult loginHandle(LoginDTO dto, UsernamePasswordToken token) {
        // 获取Subject对象
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return ServerResult.success();
        } catch (UnknownAccountException e) {
            return ServerResult.error(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return ServerResult.error(e.getMessage());
        } catch (LockedAccountException e) {
            return ServerResult.error(e.getMessage());
        } catch (AuthenticationException e) {
            return ServerResult.error("认证失败！");
        }
    }

    @PostMapping("/logout")

    public ServerResult logout(HttpServletResponse response) {
        Subject lvSubject = SecurityUtils.getSubject();
        if(lvSubject != null){
            lvSubject.logout();
        }
        return ServerResult.success();
    }

}

package com.hz.admin.controller.open;

import com.hz.admin.controller.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Classname LoginViewController
 * @Description TODO
 * @Date 2020-04-30 19:47
 * @Created by hzong
 */
@Controller
public class LoginViewController extends BaseController {

    public static final String TO_LOGIN_MAIN_PAGE = "/admin/login";
    /**
     * 登录页
     * @return
     */
    @RequestMapping("/login")
    public String toLoginMain(HttpServletRequest request){
        return getShowPath(request)+TO_LOGIN_MAIN_PAGE;
    }

}

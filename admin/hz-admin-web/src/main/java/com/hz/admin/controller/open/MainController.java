package com.hz.admin.controller.open;

import com.hz.admin.controller.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Classname MainController
 * @Description TODO
 * @Date 2019-08-31 18:14
 * @Created by hzong
 */
@Controller
public class MainController extends BaseController {

    public static final String MAIN_PAGE = "/admin/main";


    @RequestMapping("/main")
    public String main(HttpServletRequest request) {
        return getShowPath(request) + MAIN_PAGE;
    }

}

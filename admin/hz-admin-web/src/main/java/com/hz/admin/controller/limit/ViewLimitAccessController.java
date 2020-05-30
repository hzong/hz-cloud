package com.hz.admin.controller.limit;

import com.hz.admin.web.common.constants.UrlConstants;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname ViewLimitAccessController
 * @Description TODO
 * @Date 2020-05-25 22:27
 * @Created by hzong
 */
@Controller
@Validated
@RequestMapping(UrlConstants.LIMIT_VIEW)
public class ViewLimitAccessController {
    @RequestMapping("/main")
    public String main(){
        return "/hz_pc/admin/menu/main";
    }

    //===============================菜单=开始========================================

    @RequestMapping("/toMenuMain")
    public String toMenuMain(){
        return "/hz_pc/admin/menu/mainMenu";
    }

    @RequestMapping("/toMenuAdd")
    public String toAddMain(){
        return "/hz_pc/admin/menu/addMenu";
    }

    //===============================菜单=结束========================================

}

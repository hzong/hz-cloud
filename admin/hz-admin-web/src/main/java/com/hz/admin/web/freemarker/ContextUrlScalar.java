package com.hz.admin.web.freemarker;

import freemarker.template.TemplateModelException;
import freemarker.template.TemplateScalarModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Classname VersionScalar
 * @Description TODO
 * @Date 2020-04-30 21:41
 * @Created by hzong
 */
@Component
public class ContextUrlScalar implements TemplateScalarModel , InitializingBean {

    @Autowired
    WebApplicationContext webApplicationConnect;

    /**
     * 上下文路径
     */
    private String rootUrl = StringUtils.EMPTY;


    @Override
    public String getAsString() throws TemplateModelException {
        return rootUrl ;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        rootUrl = webApplicationConnect.getServletContext().getContextPath();
    }
}

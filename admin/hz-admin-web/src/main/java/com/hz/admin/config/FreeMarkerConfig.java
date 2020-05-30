package com.hz.admin.config;

import com.hz.admin.biz.ConfBiz;
import com.hz.admin.web.freemarker.ContextUrlScalar;
import com.hz.admin.web.freemarker.VersionScalar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @Classname FreeMarkerConfig
 * @Description TODO
 * @Date 2020-04-30 22:04
 * @Created by hzong
 */
@Configuration
public class FreeMarkerConfig {



    @Autowired
    private freemarker.template.Configuration configuration;
    @Autowired
    ContextUrlScalar contextUrlScalar;
    @Autowired
    VersionScalar versionScalar;
    @Autowired
    ConfBiz confBiz;


    // Spring 初始化的时候加载配置
    @PostConstruct
    public void setConfigure() throws Exception {

        // 加载html的资源路径
        configuration.setSharedVariable("context_url", contextUrlScalar);
        configuration.setSharedVariable("ver", versionScalar);
        configuration.setSharedVariable("envName", confBiz.getEnvName());

    }
}

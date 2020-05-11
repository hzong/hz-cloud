package com.hz.admin.biz;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Classname ConfBiz
 * @Description TODO
 * @Date 2020-04-30 22:30
 * @Created by hzong
 */
@Component
public class ConfBiz {

    @Value("${spring.profiles.active}")
    private String envName;

    public String getEnvName() {
        return envName;
    }
}

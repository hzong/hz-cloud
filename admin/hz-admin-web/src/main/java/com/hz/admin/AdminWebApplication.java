package com.hz.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
@SpringBootApplication(scanBasePackages="com.hz.admin")
@MapperScan("com.hz.admin.db.mapper")
public class AdminWebApplication {
    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminWebApplication.class);


    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(AdminWebApplication.class);
        springApplication.addListeners(new WebApplicationListener());
        ApplicationContext ctx = springApplication.run(args);


    }

    static class WebApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
        @Override
        public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        }


    }
}

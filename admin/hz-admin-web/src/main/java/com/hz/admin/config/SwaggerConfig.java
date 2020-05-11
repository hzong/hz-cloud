package com.hz.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Classname SwaggerConfig
 * @Description TODO
 * @Date 2020-01-07 20:03
 * @Created by hzong
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket buildDocket() {
        //TODO basePackage 扫描的controller
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInf())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hz.admin.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo buildApiInf() {
        return new ApiInfoBuilder()
                .title("管理后台的API文档")
                .contact(new Contact("hzong创建博客地址", "https://hzong.cn", "zonghuandzzh@126.com"))
                .version("1.0")
                .build();
    }
}

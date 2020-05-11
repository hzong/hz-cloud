package com.hz.admin.config;

import org.springframework.boot.validation.MessageInterpolatorFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;
import java.util.concurrent.TimeUnit;

/**
 * @Classname ValidationConfig
 * @Description TODO
 * @Date 2020-01-08 01:10
 * @Created by hzong
 */
@Configuration
public class ValidationConfig {

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setDefaultEncoding("utf-8");//读取配置文件的编码格式
        source.setCacheMillis(TimeUnit.MINUTES.toMillis(10));//缓存时间，-1表示不过期
        source.setBasename("validationMessages");//配置文件前缀名，设置为Messages,那你的配置文件必须以Messages.properties/Message_en.properties...
        return source;
    }

    @Bean
    public Validator validator() {
        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
        MessageInterpolatorFactory interpolatorFactory = new MessageInterpolatorFactory();
        factoryBean.setMessageInterpolator(interpolatorFactory.getObject());
        factoryBean.setValidationMessageSource(messageSource());
        return factoryBean;
    }
}

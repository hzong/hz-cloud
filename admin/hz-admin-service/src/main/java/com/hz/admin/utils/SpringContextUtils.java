package com.hz.admin.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * @Classname SpringUtil
 * @Description TODO
 * @Date 2019-08-15 02:05
 * @Created by hzong
 */
@Component
public final class SpringContextUtils {


    private static ApplicationContext applicationContext;

    public static   void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(SpringContextUtils.applicationContext == null) {
            SpringContextUtils.applicationContext = applicationContext;
        }
    }

    /**
     * 获取applicationContext
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }


    public static Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> var1){
        return getApplicationContext().getBeansWithAnnotation(var1);
    }



    /**
     * 通过class获取Bean.
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }

    /**
     * 通过name,以及Clazz返回指定的Bean
     * @param name
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name,Class<T> clazz){
        return getApplicationContext().getBean(name, clazz);
    }

    public static BeanDefinition getMergedBeanDefinition(String name){
        return ((DefaultListableBeanFactory)getApplicationContext().getAutowireCapableBeanFactory()).getMergedBeanDefinition(name);
    }

    public static DefaultListableBeanFactory getDefaultListableBeanFactory(){
        return ((DefaultListableBeanFactory)getApplicationContext().getAutowireCapableBeanFactory());
    }
}

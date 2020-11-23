package com.hz.admin.config;

import com.hz.admin.web.filter.TokenAuthenticationFilter;
import com.hz.admin.web.shiro.ShiroRealm;
import com.hz.admin.web.shiro.ShiroWebSessionManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;

import javax.servlet.Filter;
import java.util.LinkedHashMap;

/**
 * @Classname ShiroConfig
 * @Description Spring Boot Shiro用户认证
 * @Date 2020-01-19 23:28
 * @Created by hzong
 */
@Configuration
public class ShiroConfig {


    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 设置securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 登录的url
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后跳转的url
        shiroFilterFactoryBean.setSuccessUrl("/main");
        // 未授权url
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

        // 定义filterChain，静态资源不拦截
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/fonts/**", "anon");
        filterChainDefinitionMap.put("/img/**", "anon");
        // druid数据源监控页面不拦截
        filterChainDefinitionMap.put("/druid/**", "anon");
        // 配置退出过滤器，其中具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/", "anon");
        // 除上以外所有url都必须认证通过才可以访问，未通过认证自动访问LoginUrl
        filterChainDefinitionMap.put("/limit/**", "authc");
        // 所有请求都要经过 jwt过滤器
        filterChainDefinitionMap.put("/**", "jwt");


//        filterChainDefinitionMap.put("/css/**", "anon");
//        filterChainDefinitionMap.put("/js/**", "anon");
//        filterChainDefinitionMap.put("/fonts/**", "anon");
//        filterChainDefinitionMap.put("/img/**", "anon");
//        filterChainDefinitionMap.put("/druid/**", "anon");
//        filterChainDefinitionMap.put("/logout", "logout");
//        filterChainDefinitionMap.put("/", "anon");
//        filterChainDefinitionMap.put("/**", "authc");


        // 在 Shiro过滤器链上加入 JWTFilter
        LinkedHashMap<String, Filter> filters = new LinkedHashMap<>();
        filters.put("jwt", new TokenAuthenticationFilter());
        shiroFilterFactoryBean.setFilters(filters);


        /**
         * 需要注意的是filterChain基于短路机制，即最先匹配原则，如：
         *
         * /user/**=anon
         * /user/aa=authc 永远不会执行
         */
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }


    @Bean
    public SessionManager sessionManager() {
        return new ShiroWebSessionManager();
    }

    @Bean
    public SecurityManager securityManager(){
        // 配置SecurityManager，并注入shiroRealm
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm());
//        securityManager.setRememberMeManager(rememberMeManager());
        securityManager.setSessionManager(sessionManager());
        /**
         * 缓存存储方式
         */
//        securityManager.setCacheManager(getEhCacheManager());
        return securityManager;
    }

    @Bean
    public ShiroRealm shiroRealm(){
        // 配置Realm，需自己实现
        ShiroRealm shiroRealm = new ShiroRealm();
        return shiroRealm;
    }

    /**
     * cookie对象
     * @return
     */
    public SimpleCookie rememberMeCookie() {
        // 设置cookie名称，对应login.html页面的<input type="checkbox" name="rememberMe"/>
        SimpleCookie cookie = new SimpleCookie("rememberMe");
        // 设置cookie的过期时间，单位为秒，这里为一天
        cookie.setMaxAge(86400);
        return cookie;
    }

    /**
     * cookie管理对象
     * @return
     */
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        // rememberMe cookie加密的密钥
        cookieRememberMeManager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
        return cookieRememberMeManager;
    }
    @Bean
    public EhCacheManager getEhCacheManager() {
        EhCacheManager em = new EhCacheManager();
        em.setCacheManagerConfigFile("classpath:config/shiro-ehcache.xml");
        return em;
    }


}

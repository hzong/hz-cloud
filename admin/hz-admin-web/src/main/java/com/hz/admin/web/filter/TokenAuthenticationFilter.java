package com.hz.admin.web.filter;

import com.dzzh.hz.hzsf.common.pojo.dto.common.ResponseDTO;
import com.hz.admin.web.common.utils.ServerWebUtils;
import com.hz.admin.web.shiro.ShiroWebSessionManager;
import com.dzzh.hz.hzsf.common.codes.EResultCode;
import com.dzzh.hz.hzsf.common.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Classname TokenAuthenticationFilter
 * @Description TODO
 * @Date 2020-07-13 23:22
 * @Created by hzong
 */
public class TokenAuthenticationFilter extends AccessControlFilter {

    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TokenAuthenticationFilter.class);

    private AntPathMatcher pathMatcher = new AntPathMatcher();
    public static final String URL = "/login/auth";
    private static final String CHARSET = "UTF-8";


    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws UnauthorizedException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String[] anonUrl = StringUtils.splitByWholeSeparatorPreserveAllTokens(URL, ",");

        boolean match = false;
        for (String u : anonUrl) {
            if (pathMatcher.match(u, httpServletRequest.getRequestURI())) {
                match = true;
            }
        }
        if (match) {
            return true;
        }

        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {

        HttpServletRequest request = ServerWebUtils.toHttp(servletRequest);
        String token = request.getHeader(ShiroWebSessionManager.LOGIN_TOKEN_KEY);
        if (StringUtils.isBlank(token)) {
            ServerWebUtils.responseResult(servletResponse, JsonUtils.toString(ResponseDTO.fail(EResultCode.SERVER_ERROR_AUTH)));
            return false;
        } else if (getSubject(servletRequest, servletResponse).getPrincipal() == null) {
            ServerWebUtils.responseResult(servletResponse, JsonUtils.toString(ResponseDTO.fail(EResultCode.SERVER_ERROR_AUTH)));
            return false;
        }

        return true;
    }


    /**
     * 对跨域提供支持
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个 option请求，这里我们给 option请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }


}

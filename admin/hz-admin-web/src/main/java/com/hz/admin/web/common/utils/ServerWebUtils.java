package com.hz.admin.web.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * @Classname ServerWebUtils
 * @Description TODO
 * @Date 2020-07-13 23:43
 * @Created by hzong
 */
public class ServerWebUtils extends WebUtils {
    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ServerWebUtils.class);

    /**
     * 功能描述:返回JSON穿<br>
     *
     * @param response
     * @param msg
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void responseResult(ServletResponse response, String msg) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out;
        out = response.getWriter();
        out.write(msg);
        out.flush();
        out.close();

    }


    /**
     * 将请求参数还原为key=value的形式,for struts2
     *
     * @param params
     * @return
     */
    public static String getParamString(Map<?, ?> params) {
        StringBuffer queryString = new StringBuffer(256);
        int count = 0;
        for (Map.Entry<?, ?> entry : params.entrySet()) {
            String key = (String) entry.getKey();
            String[] param = (String[]) entry.getValue();
            for (int i = 0; i < param.length; i++) {
                if (count == 0) {
                    count++;
                } else {
                    queryString.append("&");
                }
                queryString.append(key);
                queryString.append("=");
                try {
                    queryString.append(URLEncoder.encode(param[i], "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    LOGGER.error("getParamString error", e);
                }
            }
        }
        return queryString.toString();
    }

    /**
     * 获得请求的路径及参数
     *
     * @param request
     * @return
     */
    public static String getRequestURL(HttpServletRequest request) {
        StringBuffer originalURL = new StringBuffer(request.getRequestURL());
        return originalURL.append("?").append(request.getQueryString()).toString();

    }


    public static String urlEncoder(String url) {
        try {
            return URLEncoder.encode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("urlEncoder() called with: url = [" + url + "]", e);

        }
        return StringUtils.EMPTY;
    }
}

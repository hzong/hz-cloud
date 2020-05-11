package com.hz.admin.web.controller;

import com.google.gson.JsonSyntaxException;
import com.hz.hzsf.common.constants.ServiceExceptionConstants;
import com.hz.hzsf.common.exception.ServiceException;
import com.hz.hzsf.common.pojo.code.ResultCode;
import com.hz.hzsf.common.utils.GsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Classname CommonController
 * @Description TODO
 * @Date 2020-01-08 00:28
 * @Created by hzong
 */
public class CommonController {
    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonController.class);

    protected <T> T parseJson(String json, Class<T> cls){
        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("parseJson() called with: json = 【" + json + "】, cls = 【" + cls + "】");
        }

        T t = null;
        try {
            t = GsonUtils.GSON.fromJson(json,cls);
        } catch (JsonSyntaxException e) {
            throw ServiceExceptionConstants.EXCEPTION_JSON_ERROR;
        }

        return t;
    }

}

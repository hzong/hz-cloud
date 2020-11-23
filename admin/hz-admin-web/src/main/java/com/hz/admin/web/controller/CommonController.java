package com.hz.admin.web.controller;

import com.dzzh.hz.hzsf.common.codes.EResultCode;
import com.dzzh.hz.hzsf.common.exception.ServiceException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.JsonSyntaxException;
import com.dzzh.hz.hzsf.common.constants.ServiceExceptionConstants;
import com.dzzh.hz.hzsf.common.utils.JsonUtils;
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
            t = JsonUtils.parseObject(json,cls);
        } catch (JsonSyntaxException | JsonProcessingException e) {
            throw new ServiceException(EResultCode.SERVER_ERROR,e);
        }
        return t;
    }

}

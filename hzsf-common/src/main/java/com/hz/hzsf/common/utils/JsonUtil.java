package com.hz.hzsf.common.utils;

import com.alibaba.fastjson.JSON;

/**
 * @Classname JsonUtil
 * @Description TODO
 * @Date 2020-05-21 23:26
 * @Created by hzong
 */
public final class JsonUtil {

    /**
     * 获取JSON字符串
     * @param obj
     * @return
     */
    public String getJsonString(Object obj){
        return JSON.toJSONString(obj);
    }

}

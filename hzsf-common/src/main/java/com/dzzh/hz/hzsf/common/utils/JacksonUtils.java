package com.dzzh.hz.hzsf.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @Classname JacksonUtils
 * @Description TODO
 * @Date 2020-06-01 22:14
 * @Created by hzong
 */
public  class JacksonUtils {

    private JacksonUtils() {
    }

    private static ObjectMapper MAPPER = new ObjectMapper();


    public static <T>  T parseObject(String json,Class<T> cls ) throws JsonProcessingException {
        return MAPPER.readValue(json,cls);
    }


    public static final String toString(Object obj) throws JsonProcessingException {

        return MAPPER.writeValueAsString(obj);
    }


}

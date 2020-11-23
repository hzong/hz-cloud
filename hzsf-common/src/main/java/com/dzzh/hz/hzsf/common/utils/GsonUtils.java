package com.dzzh.hz.hzsf.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @Classname GsonUtils
 * @Description TODO
 * @Date 2019-08-18 22:29
 * @Created by hzong
 */
public final class GsonUtils {

    public final static Gson GSON = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();



    public static final String toString(Object obj){
        return GSON.toJson(obj);
    }
}

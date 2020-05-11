package com.hz.hzsf.common.pojo.code;


import com.hz.hzsf.common.pojo.CommonPojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public enum  ResultCode  {



    SERVER_SUCCESS(1,"SUCCESS"),
    SERVER_ERROR(2,"服务错误"),
    SERVER_ERROR_IS_NULL(3,"参数为空"),
    SERVER_ERROR_FORBIDDEN(4,"未找到"),
    SERVER_ERROR_PARAM(5,"参数错误"),
    SERVER_ERROR_JSON(6,"json转换异常"),


    //1000以后是自定义业务逻辑请遵守规则，方便维护

    //################################分隔符######################################
    NONE(0,"NONE")
    ;
    private int code;
    private String describe;
    ResultCode(int code, String describe){
    this.code = code;
    this.describe = describe;
    }
    public int getCode() {
    return code;
    }
    public String getDescribe() {
    return describe;
    }

    private static final Map<Integer,ResultCode> hash = new HashMap<>(ResultCode.values().length);
    static {
        for (ResultCode templateType : ResultCode.values()) {
            hash.put(templateType.getCode(),templateType);
        }
    }

    /**
    * 功能描述: 转换代码<br>
    */
    public static ResultCode parseCode(Integer code, ResultCode def) {
        ResultCode val = hash.get(code);
        if(val != null){
            return val;
        }
        return def;
    }
        /**
         * 功能描述: 转换代码<br>
         */
    public static ResultCode parseCode(Integer code){
        return parseCode(code,ResultCode.NONE);
    }

    }

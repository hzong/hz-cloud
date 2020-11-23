package com.dzzh.hz.hzsf.common.codes;


import java.util.HashMap;
import java.util.Map;

public enum EResultCode {



    SERVER_SUCCESS(1,"SUCCESS"),
    SERVER_ERROR(2,"服务错误"),
    SERVER_ERROR_IS_NULL(3,"参数为空"),
    SERVER_ERROR_FORBIDDEN(4,"未找到"),
    SERVER_ERROR_PARAM(5,"参数错误"),
    SERVER_ERROR_JSON(6,"json转换异常"),
    SERVER_ERROR_AUTH(7,"AUTH ERROR"),


    //1000以后是自定义业务逻辑请遵守规则，方便维护

    //################################分隔符######################################
    NONE(0,"NONE")
    ;
    private int code;
    private String describe;
    EResultCode(int code, String describe){
    this.code = code;
    this.describe = describe;
    }
    public int getCode() {
    return code;
    }
    public String getDescribe() {
    return describe;
    }

    private static final Map<Integer, EResultCode> hash = new HashMap<>(EResultCode.values().length);
    static {
        for (EResultCode templateType : EResultCode.values()) {
            hash.put(templateType.getCode(),templateType);
        }
    }

    /**
    * 功能描述: 转换代码<br>
    */
    public static EResultCode parseCode(Integer code, EResultCode def) {
        EResultCode val = hash.get(code);
        if(val != null){
            return val;
        }
        return def;
    }
        /**
         * 功能描述: 转换代码<br>
         */
    public static EResultCode parseCode(Integer code){
        return parseCode(code, EResultCode.NONE);
    }

    }

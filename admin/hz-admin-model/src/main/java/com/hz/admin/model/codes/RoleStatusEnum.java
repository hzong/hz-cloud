package com.hz.admin.model.codes;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname EIsEnable
 * @Description TODO
 * @Date 2020-01-26 21:07
 * @Created by hzong
 */
public enum RoleStatusEnum {

    ON(1,"开"),
    OFF(2,"关"),
    NONE(0,"NONE")

    ;
    private int code;
    private String describe;
    RoleStatusEnum(int code, String describe){
    this.code = code;
    this.describe = describe;
    }
    public int getCode() {
    return code;
    }
    public String getDescribe() {
    return describe;
    }

    private static final Map<Integer, RoleStatusEnum> hash = new HashMap<>(RoleStatusEnum.values().length);
    static {
        for (RoleStatusEnum templateType : RoleStatusEnum.values()) {
            hash.put(templateType.getCode(),templateType);
        }
    }

    /**
    * 功能描述: 转换代码<br>
    */
    public static RoleStatusEnum parseCode(Integer code, RoleStatusEnum def) {
        RoleStatusEnum val = hash.get(code);
        if(val != null){
            return val;
        }
        return def;
    }
        /**
         * 功能描述: 转换代码<br>
         */
    public static RoleStatusEnum parseCode(Integer code){
        return parseCode(code, RoleStatusEnum.NONE);
    }

}

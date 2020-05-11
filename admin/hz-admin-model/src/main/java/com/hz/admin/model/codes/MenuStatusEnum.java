package com.hz.admin.model.codes;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname EIsEnable
 * @Description TODO
 * @Date 2020-01-26 21:07
 * @Created by hzong
 */
public enum MenuStatusEnum {

    ON(1,"开"),
    OFF(2,"关"),
    NONE(0,"NONE")

    ;
    private int code;
    private String describe;
    MenuStatusEnum(int code, String describe){
    this.code = code;
    this.describe = describe;
    }
    public int getCode() {
    return code;
    }
    public String getDescribe() {
    return describe;
    }

    private static final Map<Integer, MenuStatusEnum> hash = new HashMap<>(MenuStatusEnum.values().length);
    static {
        for (MenuStatusEnum templateType : MenuStatusEnum.values()) {
            hash.put(templateType.getCode(),templateType);
        }
    }

    /**
    * 功能描述: 转换代码<br>
    */
    public static MenuStatusEnum parseCode(Integer code, MenuStatusEnum def) {
        MenuStatusEnum val = hash.get(code);
        if(val != null){
            return val;
        }
        return def;
    }
        /**
         * 功能描述: 转换代码<br>
         */
    public static MenuStatusEnum parseCode(Integer code){
        return parseCode(code, MenuStatusEnum.NONE);
    }

}

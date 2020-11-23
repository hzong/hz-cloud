package com.dzzh.hz.hzsf.common.pojo.dto.common;

import com.dzzh.hz.hzsf.common.constants.ResultConstants;
import com.dzzh.hz.hzsf.common.exception.ServiceException;
import com.dzzh.hz.hzsf.common.pojo.CommonPojo;
import com.dzzh.hz.hzsf.common.codes.EResultCode;
import org.apache.commons.lang3.StringUtils;

/**
 * @Classname ResponseDTO
 * @Description TODO
 * @Date 2019-08-18 21:29
 * @Created by hzong
 */
public final class ResponseDTO<T> extends CommonPojo implements IDto {
    protected ResponseDTO() {
    }

    protected int code;
    protected T data;
    protected String msg;


    public int getCode() {
        return code;
    }

    /**
     * 不允许设置pulic
     * @param code
     * @return
     */
    ResponseDTO<T> setCode(int code) {
        this.code = code;
        return this;

    }

    /**
     * 不允许设置pulic
     * @param msg
     * @return
     */
     ResponseDTO<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    /**
     * 不允许设置pulic
     * @param data
     * @return
     */
    ResponseDTO<T> setData(T data) {
        this.data = data;
        return this;
    }



    public static <T> ResponseDTO<T> ok() {
        return ResultConstants.SUCCESS;
    }

    public static <T> ResponseDTO<T> ok(T data) {
        return getInstance(EResultCode.SERVER_SUCCESS, EResultCode.SERVER_SUCCESS.getDescribe(), data);
    }
    public static <T> ResponseDTO<T> fail(EResultCode resultCode) {
        return getInstance(EResultCode.SERVER_ERROR, resultCode.getDescribe(), null);
    }
    public static <T> ResponseDTO<T> fail(String description) {
        return getInstance(EResultCode.SERVER_ERROR, description, null);
    }
    public static <T> ResponseDTO<T> fail(String description, T data) {
        return getInstance(EResultCode.SERVER_ERROR, description, data);
    }

    public static <T> ResponseDTO<T> fail(EResultCode code, String description) {
        return new ResponseDTO<T>().setCode(code.getCode()).setMsg(description);
    }

    public static <T> ResponseDTO<T> fail() {
        return ResultConstants.SERVER_ERROR;
    }

//    public static <T> ResponseDTO<T> getInstance(EResultCode code,  T data) {
//        return getInstance(code,code.getDescribe(),data);
//    }
    private static <T> ResponseDTO<T> getInstance(EResultCode code, String description, T data) {
        if(StringUtils.isBlank(description)){
            description = code.getDescribe();
        }

        return new ResponseDTO<T>().setCode(code.getCode()).setData(data).setMsg(description);
    }
//    public static <T> ResponseDTO<T> getInstance(EResultCode code, String description) {
//        return getInstance(code,description,null);
//    }

//    public static <T> ResponseDTO<T> getInstance(EResultCode code) {
//        return getInstance(code,null,null);
//    }


    public static <T> ResponseDTO<T> getInstance(ServiceException serviceExp) {
        return getInstance(serviceExp.getResultCode(),serviceExp.getDescription(),(T) null);
    }


}

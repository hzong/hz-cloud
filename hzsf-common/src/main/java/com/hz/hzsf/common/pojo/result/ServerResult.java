package com.hz.hzsf.common.pojo.result;

import com.hz.hzsf.common.constants.ResultConstants;
import com.hz.hzsf.common.exception.ServiceException;
import com.hz.hzsf.common.pojo.CommonPojo;
import com.hz.hzsf.common.pojo.code.ResultCode;

/**
 * @Classname ServerResult
 * @Description TODO
 * @Date 2019-08-18 21:29
 * @Created by hzong
 */
public class ServerResult<T> extends CommonPojo {
    protected ServerResult() {
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
    ServerResult<T> setCode(int code) {
        this.code = code;
        return this;

    }

    /**
     * 不允许设置pulic
     * @param msg
     * @return
     */
     ServerResult<T> setMsg(String msg) {
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
    ServerResult<T> setData(T data) {
        this.data = data;
        return this;
    }



    public static <T> ServerResult<T> success() {
        return ResultConstants.SUCCESS;
    }

    public static <T> ServerResult<T> success(T data) {
        return getInstance(ResultCode.SERVER_SUCCESS, null, data);
    }

    public static <T> ServerResult<T> error(String description) {
        return getInstance(ResultCode.SERVER_ERROR, description, null);
    }



    public static <T> ServerResult<T> error() {
        return ResultConstants.SERVER_ERROR;
    }


    public static <T> ServerResult<T> getInstance(ResultCode code, String description, T data) {
        return new ServerResult<T>().setCode(code.getCode()).setData(data).setMsg(description);
    }
    public static <T> ServerResult<T> getInstance(ResultCode code, String description) {
        return getInstance(code,description,null);
    }

    public static <T> ServerResult<T> getInstance(ResultCode code) {
        return getInstance(code,null,null);
    }


    public static <T> ServerResult<T> getInstance(ServiceException serviceExp) {
        return getInstance(serviceExp.getResultCode(),serviceExp.getDescription(),(T) null);
    }


}

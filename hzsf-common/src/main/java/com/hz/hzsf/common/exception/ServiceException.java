package com.hz.hzsf.common.exception;

import com.hz.hzsf.common.pojo.code.ResultCode;
import com.hz.hzsf.common.pojo.result.ServerResult;
import org.apache.commons.lang3.StringUtils;

/**
 * @Classname ServiceException
 * @Description TODO
 * @Date 2019-08-18 21:56
 * @Created by hzong
 */
public class ServiceException extends RuntimeException {

    private ResultCode resultCode;
    private String description;



    public ServiceException(Throwable cause, ResultCode resultCode, String description) {
        super(description,cause);
        this.resultCode = resultCode;
        this.description = description;
    }

    public ServiceException(ResultCode resultCode) {
        super(resultCode.getDescribe());
        this.resultCode = resultCode;
    }



    public ServiceException(String message, ResultCode resultCode) {
        super(message);
        this.resultCode = resultCode;
    }

    public String getDescription() {
        return description;
    }



    public ResultCode getResultCode() {
        return resultCode;
    }

    public ServerResult serverResult() {
        return ServerResult.getInstance(resultCode,null);
    }

    public ServerResult serverMsgResult() {
        String dec = StringUtils.isNotBlank(description) ? description :resultCode.getDescribe();
        return ServerResult.getInstance(resultCode,dec,null
                );
    }


    public static  final <T> ServerResult<T> createServerResult(ServiceException serviceExp){
        return ServerResult.getInstance(serviceExp);
    }

}

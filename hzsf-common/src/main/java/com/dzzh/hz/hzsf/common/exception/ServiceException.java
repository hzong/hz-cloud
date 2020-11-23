package com.dzzh.hz.hzsf.common.exception;

import com.dzzh.hz.hzsf.common.codes.EResultCode;
import com.dzzh.hz.hzsf.common.pojo.dto.common.ResponseDTO;
import org.apache.commons.lang3.StringUtils;

/**
 * @Classname ServiceException
 * @Description TODO
 * @Date 2019-08-18 21:56
 * @Created by hzong
 */
public class ServiceException extends RuntimeException {

    private EResultCode resultCode;
    private String description;



    public ServiceException(EResultCode resultCode,String description,Throwable cause) {
        super(description,cause);
        this.resultCode = resultCode;
        this.description = description;
    }

    public ServiceException(EResultCode resultCode) {
        this(resultCode,resultCode.getDescribe(),null);
    }



    public ServiceException(EResultCode resultCode,String description) {
        this(resultCode,description,null);
    }
    public ServiceException(EResultCode resultCode,Throwable cause) {
        this(resultCode,resultCode.getDescribe(),cause);
    }

    public String getDescription() {
        return description;
    }



    public EResultCode getResultCode() {
        return resultCode;
    }

    public ResponseDTO serverResult() {
        return ResponseDTO.fail(resultCode);
    }

    public ResponseDTO serverMsgResult() {
        String dec = StringUtils.isNotBlank(description) ? description : resultCode.getDescribe();
        return ResponseDTO.fail(resultCode,dec
                );
    }


    public static  final <T> ResponseDTO<T> createServerResult(ServiceException serviceExp){
        return ResponseDTO.getInstance(serviceExp);
    }

}

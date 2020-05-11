package com.hz.hzsf.common.constants;

import com.hz.hzsf.common.exception.ServiceException;
import com.hz.hzsf.common.pojo.code.ResultCode;

/**
 * @Classname ServiceExceptionConstants
 * @Description TODO
 * @Date 2020-01-08 00:33
 * @Created by hzong
 */
public interface ServiceExceptionConstants {

    ServiceException EXCEPTION_JSON_ERROR = new ServiceException(ResultCode.SERVER_ERROR_JSON);
}

package com.dzzh.hz.hzsf.common.constants;

import com.dzzh.hz.hzsf.common.exception.ServiceException;
import com.dzzh.hz.hzsf.common.codes.EResultCode;

/**
 * @Classname ServiceExceptionConstants
 * @Description TODO
 * @Date 2020-01-08 00:33
 * @Created by hzong
 */
public interface ServiceExceptionConstants {

    ServiceException EXCEPTION_JSON_ERROR = new ServiceException(EResultCode.SERVER_ERROR_JSON);
}

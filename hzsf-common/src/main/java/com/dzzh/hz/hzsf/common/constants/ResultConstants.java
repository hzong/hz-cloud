package com.dzzh.hz.hzsf.common.constants;

import com.dzzh.hz.hzsf.common.codes.EResultCode;
import com.dzzh.hz.hzsf.common.pojo.dto.common.ResponseDTO;

/**
 * @Classname ResultConstants
 * @Description TODO
 * @Date 2020-01-02 01:17
 * @Created by hzong
 */
public interface ResultConstants {

    ResponseDTO SUCCESS = ResponseDTO.fail(EResultCode.SERVER_SUCCESS);
    ResponseDTO SERVER_ERROR = ResponseDTO.fail(EResultCode.SERVER_ERROR);
    ResponseDTO SERVER_ERROR_IS_NULL = ResponseDTO.fail(EResultCode.SERVER_ERROR_IS_NULL);
    ResponseDTO SERVER_ERROR_FORBIDDEN = ResponseDTO.fail(EResultCode.SERVER_ERROR_FORBIDDEN);
    ResponseDTO SERVER_ERROR_PARAM = ResponseDTO.fail(EResultCode.SERVER_ERROR_PARAM);


    //1000以后是自定义业务逻辑请遵守规则，方便维护

}

package com.hz.hzsf.common.constants;

import com.hz.hzsf.common.pojo.code.ResultCode;
import com.hz.hzsf.common.pojo.result.ServerResult;

/**
 * @Classname ResultConstants
 * @Description TODO
 * @Date 2020-01-02 01:17
 * @Created by hzong
 */
public interface ResultConstants {

    ServerResult SUCCESS = ServerResult.getInstance(ResultCode.SERVER_SUCCESS);
    ServerResult SERVER_ERROR = ServerResult.getInstance(ResultCode.SERVER_ERROR);
    ServerResult SERVER_ERROR_IS_NULL = ServerResult.getInstance(ResultCode.SERVER_ERROR_IS_NULL);
    ServerResult SERVER_ERROR_FORBIDDEN = ServerResult.getInstance(ResultCode.SERVER_ERROR_FORBIDDEN);
    ServerResult SERVER_ERROR_PARAM = ServerResult.getInstance(ResultCode.SERVER_ERROR_PARAM);


    //1000以后是自定义业务逻辑请遵守规则，方便维护

}

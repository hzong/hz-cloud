package com.hz.hzsf.common.handler;

import com.hz.hzsf.common.constants.ResultConstants;
import com.hz.hzsf.common.exception.ServiceException;
import com.hz.hzsf.common.pojo.code.ResultCode;
import com.hz.hzsf.common.pojo.result.ServerResult;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.List;
import java.util.Set;

/**
 * @Classname BaseExceptionHandler
 * @Description TODO
 * @Date 2020-01-05 19:27
 * @Created by hzong
 */
public class BaseExceptionHandler {
    
    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ServerResult handleException(Exception e) {
        LOGGER.error("服务器异常："+"handleException() called with: e = [" + e + "]",e);
        return ResultConstants.SERVER_ERROR;
    }



    /**
     * 处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = ServiceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ServerResult handleServiceException(ServiceException e) {
        LOGGER.error("服务器异常："+"handleFebsException() called with: e = [" + e + "]",e);
        return e.serverResult();
    }
    /**
     * 统一处理请求参数校验(实体对象传参)
     *
     * @param e BindException
     * @return FebsResponse
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ServerResult handleBindException(BindException e) {
        StringBuilder message = new StringBuilder();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        for (FieldError error : fieldErrors) {
            message.append(error.getField()).append(error.getDefaultMessage()).append(",");
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        return ServerResult.getInstance(ResultCode.SERVER_ERROR_PARAM,message.toString());
    }

    /**
     * 统一处理请求参数校验(实体对象传参)
     *
     * @param e BindException
     * @return FebsResponse
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ServerResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        StringBuilder message = new StringBuilder();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        for (FieldError error : fieldErrors) {
            message.append(error.getField()).append(error.getDefaultMessage()).append(",");
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        return ServerResult.getInstance(ResultCode.SERVER_ERROR_PARAM,message.toString());
    }

    /**
     * 统一处理请求参数校验(普通传参)
     *
     * @param e ConstraintViolationException
     * @return FebsResponse
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ServerResult handleConstraintViolationException(ConstraintViolationException e) {
        StringBuilder message = new StringBuilder();
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            Path path = violation.getPropertyPath();
            String[] pathArr = StringUtils.splitByWholeSeparatorPreserveAllTokens(path.toString(), ".");
            message.append(pathArr[1]).append(violation.getMessage()).append(",");
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        return ServerResult.getInstance(ResultCode.SERVER_ERROR_PARAM,message.toString());
    }


}

package com.hz.admin.web.exception;

import com.dzzh.hz.hzsf.web.handler.BaseExceptionHandler;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * @Classname ControllerExceptionHandler
 * @Description TODO
 * @Date 2020-01-06 00:07
 * @Created by hzong
 */
@ControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class ControllerExceptionHandler extends BaseExceptionHandler {
}

package com.hz.admin.web.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常统一处理
 * @author ShengHao
 *
 *         2016年11月22日 - 上午10:59:43
 */
public class GlobalExceptionHandler implements HandlerExceptionResolver {

	/**
	 * logger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);


	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		LOGGER.error("发生异常，异常信息：" , ex.toString());
		return new ModelAndView("/exception/globalExceptionPage");
	}

}

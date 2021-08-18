package com.woniuxy.domain;

import com.woniuxy.controller.TestExceptionController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author: rua
 * 配置全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	private static final Log log = LogFactory.getLog(TestExceptionController.class);

	@ExceptionHandler({Exception.class})
	public String handleException(Throwable e) {
		log.info(e.getClass() + "->" + e.getMessage()); //以日志形式将异常信息输出在后台
		return "error"; //以试图方式将页面展示给客户端
	}

}

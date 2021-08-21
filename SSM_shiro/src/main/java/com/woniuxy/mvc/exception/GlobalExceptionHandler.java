package com.woniuxy.mvc.exception;

import com.woniuxy.util.LogUtil;
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

	@ExceptionHandler(Exception.class)
	public String handleException(Exception e) {
		LogUtil.writeError("ERROR>>>>>>>>>>>>>"+e.getClass()+"-->>"+e.getMessage());
		return "error";
	}

}

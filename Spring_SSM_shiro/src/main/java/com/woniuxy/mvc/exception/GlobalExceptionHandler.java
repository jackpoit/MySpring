package com.woniuxy.mvc.exception;

import com.woniuxy.util.LogUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author: rua
 * 配置全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UnauthorizedException.class)
	public String handleUnauthorizedException(UnauthorizedException e) {
		LogUtil.writeError("ERROR>>>>>>>>>>>>>"+"权限不足");
		return "unauthorized";
	}
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e) {
		LogUtil.writeError("ERROR>>>>>>>>>>>>>"+e.getClass()+"-->>"+e.getMessage());
		return "error";
	}

}

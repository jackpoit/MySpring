package com.woniuxy.util;

import com.woniuxy.mvc.exception.GlobalExceptionHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @Author: rua
 * @Date: 2021/8/21 16:36
 * @Description:
 */
public class LogUtil {
	public static final Log LOG = LogFactory.getLog(GlobalExceptionHandler.class);

	public static void writeDebug(String msg) {
		LOG.debug(msg);
	}

	public static void writeInfo(String msg) {
		LOG.info(msg);
	}

	public static void writeError(String msg) {
		LOG.error(msg);
	}


}

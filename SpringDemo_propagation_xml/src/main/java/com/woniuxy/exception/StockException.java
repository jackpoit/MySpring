package com.woniuxy.exception;

/**
 * @Author: rua
 * @Date: 2021/8/17 17:07
 * @Description:
 */
public class StockException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public StockException() {
		super();
	}

	public StockException(String message) {
		super(message);
	}

	public StockException(String message, Throwable cause) {
		super(message, cause);
	}

	public StockException(Throwable cause) {
		super(cause);
	}

	protected StockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}

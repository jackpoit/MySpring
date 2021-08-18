package com.woniuxy.exception;

/**
 * @Author: rua
 * @Date: 2021/8/17 17:06
 * @Description:
 */
public class BalanceException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public BalanceException() {
		super();
	}

	public BalanceException(String message) {
		super(message);
	}

	public BalanceException(String message, Throwable cause) {
		super(message, cause);
	}

	public BalanceException(Throwable cause) {
		super(cause);
	}

	protected BalanceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}

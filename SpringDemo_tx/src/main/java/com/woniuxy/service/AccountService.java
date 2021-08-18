package com.woniuxy.service;

import java.math.BigDecimal;

public interface AccountService {
	/**
	 * 转账
	 * @param from
	 * @param to
	 * @param money
	 * @return
	 */
	boolean transferMoney(String from, String to, BigDecimal money);
}

package com.woniuxy.dao;

import java.math.BigDecimal;

public interface AccountDao {

	/**
	 * 扣钱方法
	 * @param name
	 * @param money
	 * @return
	 */
	int subMoney(String name, BigDecimal money);

	/**
	 * 存钱方法
	 * @param name
	 * @param money
	 * @return
	 */
	int addMoney(String name, BigDecimal money);

}

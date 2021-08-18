package com.woniuxy.dao;

import java.math.BigDecimal;

public interface BookShopDao {

	/**
	 * 根据图书编号查询图书价格
	 * @param isbn
	 * @return
	 */
	BigDecimal findBookPriceByIsbn(String isbn);

	/**
	 * 更新图书库存 默认每次只能买一本
	 * @param isbn
	 * @return
	 */
	int updateBookStock(String isbn);

	/**
	 * 更新用户余额(买书扣钱)
	 * @param name
	 * @param price
	 * @return
	 */
	int updateAccountBalance(String name,BigDecimal price);



}

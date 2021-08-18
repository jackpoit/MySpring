package com.woniuxy.service;

import java.math.BigDecimal;

public interface BookShopService {

	/**
	 * 根据书编号和用户来购买图书
	 * @param isbn
	 * @param username
	 */
	boolean purchase(String isbn,String username);
}

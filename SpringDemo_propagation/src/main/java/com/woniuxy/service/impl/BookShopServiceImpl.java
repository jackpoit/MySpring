package com.woniuxy.service.impl;

import com.woniuxy.dao.BookShopDao;
import com.woniuxy.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @Author: rua
 * @Date: 2021/8/17 16:34
 * @Description:
 */
@Service
public class BookShopServiceImpl implements BookShopService {
	@Autowired
	private BookShopDao dao;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public boolean purchase(String isbn, String username) {
		if (isbn==null||username==null)
			return false;
		//1.根据图书编号isbn查询价格
		BigDecimal price = dao.findBookPriceByIsbn(isbn);
		//2.购买一本书后需要更新图书库存
		int row = dao.updateBookStock(isbn);
		if (row <= 0)
			throw new RuntimeException();

//		int a=10/0;

		//3.购买成功后用户账户余额要更新
		row = dao.updateAccountBalance(username, price);
		if (row <= 0)
			throw new RuntimeException();

		return true;
	}
}

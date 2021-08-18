package com.woniuxy.dao.impl;

import com.woniuxy.dao.BookShopDao;
import com.woniuxy.exception.BalanceException;
import com.woniuxy.exception.StockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * @Author: rua
 * @Date: 2021/8/17 16:40
 * @Description:
 */
@Repository
public class BookShopDaoImpl implements BookShopDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public BigDecimal findBookPriceByIsbn(String isbn) {
		String sql="SELECT price FROM t_books WHERE isbn=?";
		return jdbcTemplate.queryForObject(sql,BigDecimal.class,isbn);
	}

	@Override
	public int updateBookStock(String isbn) {
		//库存验证
		String sql="SELECT stock FROM book_stock WHERE isbn=?";
		Integer stock = jdbcTemplate.queryForObject(sql, int.class,isbn);
		if (stock<=0)
			throw new StockException("图书库存不足");
		//更新
		String sql2="UPDATE book_stock SET stock=stock-? WHERE isbn=?";
		return jdbcTemplate.update(sql2,1,isbn);
	}

	@Override
	public int updateAccountBalance(String name, BigDecimal price) {
		//余额验证
		String sql="SELECT balance FROM t_account WHERE name=?";
		BigDecimal balance = jdbcTemplate.queryForObject(sql, BigDecimal.class,name);
		if (balance.compareTo(price)<0)
			throw new BalanceException("账户余额不足");

		//更新
		String sql2="UPDATE t_account SET balance=balance-? WHERE name=?";
		return jdbcTemplate.update(sql2,price,name);
	}
}

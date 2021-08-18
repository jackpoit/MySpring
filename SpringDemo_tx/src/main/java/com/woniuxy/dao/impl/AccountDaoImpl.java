package com.woniuxy.dao.impl;

import com.woniuxy.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * @Author: rua
 * @Date: 2021/8/17 15:46
 * @Description: 操作数据库的CRUD
 */
@Repository
public class AccountDaoImpl implements AccountDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int subMoney(String name, BigDecimal money) {
		String sql="UPDATE t_account SET balance=balance-? WHERE name=?";
		return jdbcTemplate.update(sql,money,name);
	}

	@Override
	public int addMoney(String name, BigDecimal money) {
		String sql="UPDATE t_account SET balance=balance+? WHERE name=?";
		return jdbcTemplate.update(sql,money,name);
	}
}

package com.woniuxy.service.impl;

import com.woniuxy.dao.AccountDao;
import com.woniuxy.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.SQLException;

/**
 * @Author: rua
 * @Date: 2021/8/17 15:43
 * @Description: 业务类的实现类[真实的业务逻辑]
 */
@Transactional//给类层面的所有方法都加了事务
@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDao accountDao;

	//	@Transactional//基于声明式的注解事务[通过AOP控制事务]
	@Override
	public boolean transferMoney(String from, String to, BigDecimal money) {
		if (from == null || to == null || money == null) {
			return false;
		}

		//1.转账人扣钱
		int row = accountDao.addMoney(from, money);
		if (row <= 0)
			throw new RuntimeException();

		int a=10/0;
		//2.收款人存钱
		row = accountDao.subMoney(to, money);
		if (row<=0)
			throw new RuntimeException();

		return true;
	}
}

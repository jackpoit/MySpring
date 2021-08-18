package com.woniuxy;

import com.woniuxy.dao.AccountDao;
import com.woniuxy.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

/**
 * @Author: rua
 * @Date: 2021/8/17 15:50
 * @Description:
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class SpringTest {

	@Autowired
	private AccountDao accountDao;

	@Autowired
	private AccountService accountService;

	@Test
	public void addMoney(){
//		int row = accountDao.addMoney("张三", new BigDecimal("100"));
		int row = accountDao.subMoney("张三", new BigDecimal("100"));
		System.out.println(row);
	}

	@Test
	public void transTest(){

		boolean flag = accountService.transferMoney("张三", "李四", new BigDecimal("200"));
		System.out.println(flag);
	}
}

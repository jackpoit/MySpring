package com.woniuxy;

import com.woniuxy.dao.BookShopDao;
import com.woniuxy.service.BookShopService;
import com.woniuxy.service.CustomerService;
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
	private BookShopDao dao;

	@Autowired
	private BookShopService service;

	@Autowired
	private CustomerService customerService;

	@Test
	public void test01(){
		BigDecimal price = dao.findBookPriceByIsbn("0001");
		int row = dao.updateBookStock("0001");
		int row2 = dao.updateAccountBalance("jack", price);
		System.out.println(price);
		System.out.println(row);
		System.out.println(row2);

	}

	@Test
	public void test02(){
		service.purchase("0001","rose");
	}
	@Test
	public void test03(){
		customerService.checkout("jack","0001","0002");
	}

}

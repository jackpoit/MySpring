package com.woniuxy.service.impl;

import com.woniuxy.service.BookShopService;
import com.woniuxy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: rua
 * @Date: 2021/8/17 17:02
 * @Description: 客户结账的业务逻辑层实现类
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private BookShopService bookShopService;

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void checkout(String name, String... isbns) {
		if(name==null||isbns==null)
			return ;

		//实现一本一本购买
		for (String isbn : isbns) {
			bookShopService.purchase(isbn,name); //一次买一本
		}


	}
}

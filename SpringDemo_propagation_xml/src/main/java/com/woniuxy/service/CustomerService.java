package com.woniuxy.service;

/**
 * @Author: rua
 * @Date: 2021/8/17 17:01
 * @Description: 客户结账的业务接口
 */
public interface CustomerService {

	/**
	 * 客户可以购买多本书
	 * @param name
	 * @param isbns
	 */
	void checkout(String name,String...isbns);
}

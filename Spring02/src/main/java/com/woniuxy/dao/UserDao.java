package com.woniuxy.dao;

import org.springframework.stereotype.Repository;

/**
 * @Author: rua
 * @Date: 2021/8/11 11:31
 * @Description:
 */

@Repository("userDao")
public class UserDao {

	public void add(){
		System.out.println("userDao add");
	}

	public void init(){
		System.out.println("userDao init");
	}

	public void destroy(){
		System.out.println("userDao destroy");
	}

}

package com.woniuxy.dao.impl;

import com.woniuxy.dao.UserDao;

/**
 * @Author: rua
 * @Date: 2021/8/15 18:17
 * @Description:
 */
public class UserDaoImpl implements UserDao {
	@Override
	public void add() {
		System.out.println("userDao执行了add()");
	}

	@Override
	public void delete() {
		System.out.println("userDao执行了delete()");

	}

	@Override
	public void update() {
		System.out.println("userDao执行了update()");

	}

	@Override
	public void find() {
		System.out.println("userDao执行了find()");
	}
}

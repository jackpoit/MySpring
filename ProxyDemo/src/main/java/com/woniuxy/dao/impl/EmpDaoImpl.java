package com.woniuxy.dao.impl;

import com.woniuxy.dao.EmpDao;
import com.woniuxy.util.Tools;

/**
 * @Author: rua
 * @Date: 2021/8/15 18:17
 * 需要完成:核心逻辑不修改的情况下能否完成相关功能
 * 新的情况:一个类没有实现任何接口,如何为它产生代理呢?
 * Proxy不行,就需要使用Cglib
 *
 */
public class EmpDaoImpl implements EmpDao {
	@Override
	public void add() {
		System.out.println("empDAO执行了add()");
	}

	@Override
	public void delete() {
		int code = Tools.preCheck();
		code ^= 123;
		System.out.println("empDAO执行了delete()" + code);
	}

	@Override
	public void update() {
		System.out.println("empDAO执行了update()");

	}

	@Override
	public void find() {
		System.out.println("empDAO执行了find()");
	}
}

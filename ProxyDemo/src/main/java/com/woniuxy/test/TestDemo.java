package com.woniuxy.test;

import com.woniuxy.dao.EmpDao;
import com.woniuxy.dao.impl.EmpDaoImpl;
import com.woniuxy.dao.proxys.EmpStaticProxy;

/**
 * @Author: rua
 * @Date: 2021/8/15 18:19
 * @Description:
 */
public class TestDemo {
	public static void main(String[] args) {
		EmpDao empDao = new EmpDaoImpl();
		EmpStaticProxy proxy = new EmpStaticProxy(empDao);
		proxy.add();
		proxy.delete();
		proxy.update();
		proxy.find();
	}
}

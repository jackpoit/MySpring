package com.woniuxy.test;

import com.woniuxy.dao.EmpDao;
import com.woniuxy.dao.UserDao;
import com.woniuxy.dao.impl.EmpDaoImpl;
import com.woniuxy.dao.impl.UserDaoImpl;
import com.woniuxy.dao.proxys.MyProxys;

/**
 * @Author: rua
 * @Date: 2021/8/15 19:03
 * @Description:
 */
//功能:将service中的所有find方法加事务
public class ProxyTest {
	public static void main(String[] args) {
		//被代理对象
		EmpDaoImpl empDao = new EmpDaoImpl();
		UserDao userDao = new UserDaoImpl();
		//创建动态代理对象[动态代理对象通过反射创建出来]
		EmpDao empProxy = (EmpDao) new MyProxys(empDao).createProxy();
		UserDao userProxy = (UserDao) new MyProxys(userDao).createProxy();

		empProxy.add();

		userProxy.add();
	}
}

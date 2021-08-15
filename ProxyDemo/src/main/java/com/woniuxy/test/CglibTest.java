package com.woniuxy.test;

import com.woniuxy.dao.impl.EmpDaoImpl;
import com.woniuxy.dao.impl.ProductDaoImpl;
import com.woniuxy.dao.impl.UserDaoImpl;
import com.woniuxy.dao.proxys.MyCglib;

/**
 * @Author: rua
 * @Date: 2021/8/15 20:21
 * @Description:
 */
public class CglibTest {
	public static void main(String[] args) {
		//没有实现接口的类
		ProductDaoImpl productDao = new ProductDaoImpl();
		//需要使用Cglib产生动态代理对象
		Object obj = new MyCglib(productDao).createProxy();
		if (obj instanceof ProductDaoImpl) {
			ProductDaoImpl proxy = (ProductDaoImpl) obj;
			proxy.add();
			proxy.find();
			proxy.findAll();
		}

		//实现了接口的类
		EmpDaoImpl empDao = new EmpDaoImpl();
			//Target目标对象:	empDao:被增强的对象
		EmpDaoImpl proxy = (EmpDaoImpl) new MyCglib(empDao).createProxy();
		//Proxy代理对象:通过动态代理模式产生的[Proxy/Cglib]

		//joinPoint:连接点 :所有可能增强的方法
		proxy.add();	//cutPoint:切入点:正在增强的方法
		proxy.find();
		//Advice:增强方法[通知] 5种:
		//前置通知,后置通知,环绕通知,异常抛出通知,最终通知
		//通知+切入点:切面

		//织入 weaving:在切入点上应用通知的过程(切入点方法被增强的过程)

		//Introduction:类层面:如给类增加一个方法
	}
}

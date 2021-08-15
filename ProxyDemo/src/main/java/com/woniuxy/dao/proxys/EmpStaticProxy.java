package com.woniuxy.dao.proxys;

import com.woniuxy.dao.EmpDao;
import com.woniuxy.util.Tools;

/**
 * @Author: rua
 * 静态代理设计模式
 * 1.让代理对象实现被代理对象的接口
 * 2.将被代理对象作为代理对象的成员
 * EmpDaoImpl   EmpStaticProxy
 * <p>
 * 优点:在保证代理对象核心逻辑不变的情况下,可以知道添加一些与逻辑无关的非业务代码
 * 日志打印
 * 权限校验
 * 性能检测
 * <p>
 * 缺点:要为每一个被代理的对象在编译期创建一个静态代理类[导致静态代理类过多]
 * <p>
 * 装饰者模式
 */
public class EmpStaticProxy implements EmpDao {

	private EmpDao empDao;

	public EmpStaticProxy(EmpDao empDao) { //代理对象要知道它在为谁做代理
		this.empDao = empDao;
	}

	@Override
	public void add() {
		Tools.writeLog();
		empDao.add();
	}

	@Override
	public void delete() {
		Tools.preCheck();
		empDao.delete();
	}

	@Override
	public void update() {
		Tools.writeLog();
		empDao.update();
		Tools.writeLog();
	}

	@Override
	public void find() {
		Tools.preCheck();
		empDao.find();
	}
}

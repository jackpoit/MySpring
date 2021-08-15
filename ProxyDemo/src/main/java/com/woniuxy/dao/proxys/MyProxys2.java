package com.woniuxy.dao.proxys;

import com.woniuxy.util.Tools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: rua
 * 基于JDK内置的Proxy动态代理 [反射包下的Proxy]
 * 前提:被代理对象一定要实现接口,否则不能使用此方法来为这个对象做代理
 * 1.将被代理对象作为代理类的成员
 * 2.通过Proxy产生基于接口的动态代理对象
 * 3.对核心业务逻辑增强[增强invoke]
 */
public class MyProxys2  {

	private Object obj;//引入被代理对象

	public MyProxys2(Object obj) {
		this.obj = obj;
	}

	/**
	 * 返回的是被代理对象
	 * loader:加载了被代理对象的类加载器
	 * interfaces:被代理对象上的所有实现的接口
	 * handler:InvocationHandle代理的回调方法
	 *
	 */
	public Object createProxy() {
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Object result = null;
				if (method.getName().startsWith("add")) {
					Tools.writeLog();
					result = method.invoke(obj, args);
				} else if (method.getName().startsWith("delete")) {
					Tools.preCheck();//非核心业务
					result = method.invoke(obj, args); //核心方法
					Tools.preCheck();//非核心业务
				} else {
					result = method.invoke(obj, args); //核心方法
				}
				return result;
			}
		});
	}


}

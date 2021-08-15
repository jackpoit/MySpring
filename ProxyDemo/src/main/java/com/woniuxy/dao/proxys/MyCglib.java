package com.woniuxy.dao.proxys;

import com.woniuxy.util.Tools;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: rua
 * 基于Cglib产生的动态代理
 * 1.将被代理对象作为代理对象的成员
 * 2.创建cglib的增强对象(设置父类,方法拦截回调,创建代理对象)
 * 3.将代理拦截的方法intercept进行增强
 *
 * 场景:主要用于为没有接口的类来产生动态代理对象,当然也可以为实现了接口的类产生动态代理对象
 *
 * 总结:后期会使用AOP[面向切面编程] OOP[面向对象编程] (面向接口编程,面向xx编程)
 * 		AOP底层实现原理就是:动态代理设计
 * 		若类实现了接口,则默认采用Proxy方式来创建动态代理对象
 * 		若类没有实现了接口,则会自动采用Cglib方式来创建动态代理对象
 *
 */
public class MyCglib implements MethodInterceptor {
	private Object obj;

	public MyCglib(Object obj) {
		this.obj = obj;
	}

	/**
	 * 产生基于Cglib的动态代理对象
	 *
	 * @return
	 */
	public Object createProxy() {
		//1.创建Cglib的核心对象
		Enhancer enhancer = new Enhancer();
		//2.将被代理对象设置为它的父类
		enhancer.setSuperclass(obj.getClass());
		//3.增强被代理的方法:方法代理回调
		enhancer.setCallback(this); //callback是父类接口,一般使用它的子接口:方法拦截器
		//4.产生代理对象并返回
		return enhancer.create();
	}


	/**
	 * cglib的方法拦截
	 * @param proxy
	 * @param method
	 * @param args
	 * @param methodProxy
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
//		Object result = methodProxy.invokeSuper(proxy, args); //proxy产生的代理对象,methodProxy:代理对象方法,invokeSuper代理对象方法

//		Object result = method.invoke(obj, args); //同proxy中的invoke一样

		Object result = null;
		if (method.getName().startsWith("find")) {
			long start=System.currentTimeMillis();
			result = method.invoke(obj, args);
			long end=System.currentTimeMillis();
			System.out.println("耗时"+(end-start)+"秒");
		}  else {
			result = method.invoke(obj, args); //核心方法
		}
		return result;

	}
}

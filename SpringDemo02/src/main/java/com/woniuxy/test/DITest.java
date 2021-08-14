package com.woniuxy.test;

import com.woniuxy.entity.Bean;
import com.woniuxy.entity.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @Author: rua
 * @Date: 2021/8/14 14:05
 * @Description:
 */

/**
 * 面试1:
 *  	Q1:什么是IOC,什么是DI
 * 			IOC:控制反转,将我们之前手动new创建对象的过程交给了Spring工厂来帮助我们创建
 * 		Q2:为什么要IOC?
 * 			解耦:增强代码的灵活性和扩展性(IOC原理:Xml+工厂+反射体现多态,IOC就是多态的应用)  OCP原则
 *		Q3:什么是DI?
 *			DI:Dependency Injection 依赖注入
 *			给IOC管理的对象属性赋值[DI必须在IOC环境下才可以完成]
 *
 *		Q4:Spring实现DI的方式有哪些?
 *			构造注入:1.通过形参索引/通过形参名(参数容易错位,使用不方便,开发基本不用)
 *			SetXxxx注入:开发主流[保证数据赋值的正确性(可以在set中加一些判断)]
 *
 *
 *
 * */
public class DITest {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application2.xml");
		Bean bean = applicationContext.getBean(Bean.class);
		//测试数组的DI
		System.out.println(Arrays.toString(bean.getArr()));
		//测试list集合类型的DI
		System.out.println(bean.getLists());
		//测试set集合类型的DI(可实现去重)
		System.out.println(bean.getSets());
		//测试HashMap类型的DI
		System.out.println(bean.getHashMap());


	}

}

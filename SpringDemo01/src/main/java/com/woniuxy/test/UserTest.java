package com.woniuxy.test;

import com.woniuxy.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @Author: rua
 * @Date: 2021/8/12 19:55
 * @Description:
 */
public class UserTest {
	@Test
	public void test01() {
		//传统方式创建对象
//		User user = new User();
//		System.out.println(user);

		//需要将user对象的创建交给Spring容器来完成
		//Spring新工厂:ApplicationContext
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
//		FileSystemXmlApplicationContext fileSystemXmlApplicationContext = new FileSystemXmlApplicationContext("E:/application.xml");
		/**
		 * 面试1:新工厂与旧工厂的区别
		 * 		旧工厂是BeanFactory:当工厂创建时不会将配置的所有bean全部做初始化,而是真正在使用时才会创建出来
		 * 	  	新工厂是ApplicationContext:当工厂创建时会将配置的所有bean全部做初始化
		 * 	  		ClassPathXmlApplicationContext:加载的是类路径下的xml(相对路径)
		 * 	  		FileSystemXmlApplicationContext:加载的是本地磁盘路径
		 *
		 *			ConfigurableApplicationContext 扩展于 ApplicationContext，新增加两个主要方法：refresh() 和 close()，
		 * 			让 ApplicationContext 具有启动、刷新和关闭上下文的能力
		 *
		 * //多例模式下新工厂也不会创建bean 只会在getBean时创建bean
		 *
		 * 面试2:Spring在管理Bean时的生命周期
		 *		创建:Spring 容器创建时就创建
		 *		初始化:对创建出来的对象做相关的赋值,初始化操作
		 *	 	销毁:Spring容器销毁之前销毁对象
		 */

		Object bean = applicationContext.getBean("user");
		Object bean1 = applicationContext.getBean(User.class);  //Spring工厂创建出来的对象默认是单例的
//		System.out.println(bean);
//		System.out.println(user==bean);
		//工厂+反射+xml =>IOC

		applicationContext.close();//销毁Spring工厂(工厂不会销毁的)
//		单例模式下 工厂close()对象会销毁 会自动创建 初始化对象
//		多例模式 工厂close()对象不会销毁,因为有多个对象 工厂不知道要销毁哪一个 不会自动创建 初始化对象


	}

	@Test
	public void test02(){
//		User user = new User();

		//创建Spring新工厂ApplicationContext
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");

		//1.从工厂获取bean的方式一:idName
		User u1 = (User) applicationContext.getBean("user");
		User u3 = (User) applicationContext.getBean("user2");
		System.out.println(u1==u3);
		//结果为false 因为都是通过getBean得到的 底层通过newInstance()得到的 所以不同


		//2.按照类型来获取对象[需要保证这个类型的对象要唯一]
		User u2 = applicationContext.getBean(User.class);//bean唯一才可以用
		System.out.println(u1);
		System.out.println(u2);
		System.out.println(u1==u2);

	}
}

package com.woniu.web.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Author: rua
 * @Date: 2021/8/14 22:37
 * @Description: 监听ServletContext的创建和销毁(Spring整合Web应用的思想)
 */
public class MyServletContextListener implements ServletContextListener {
	private ClassPathXmlApplicationContext applicationContext = null;

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		//监听到ServletContext对象的创建:服务器发布项目时只会创建一次[contextInitialized只会执行一次]
		applicationContext = new ClassPathXmlApplicationContext("application.xml");
		ServletContext servletContext = servletContextEvent.getServletContext();
		servletContext.setAttribute("applicationContext", applicationContext);

	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		if (applicationContext!=null)
			applicationContext.close();

	}
}

package com.woniuxy.test;

import com.woniuxy.bean.App;
import com.woniuxy.controller.AppController;
import com.woniuxy.controller.TestController;
import com.woniuxy.util.UpLoadUtil;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * @Author: rua
 * @Date: 2021/8/12 11:40
 * @Description:
 */
public class JTest {

	@Test
	public void add() {
		App app = new App();
		app.setAppName("jack11111");
		app.setAppType("啦啦");
		app.setAppPlatform("哈哈");
		app.setAppSize(111);
		app.setAppCount(0);
		app.setAppImg(" ");
		ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("application.xml");
		AppController appController = (AppController) application.getBean("appController");
		appController.addApp(app);

	}
	@Test
	public void query() {
		ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("application.xml");
		AppController appController = (AppController) application.getBean("appController");
		appController.queryApp();

	}
	@Test
	public void dataSource() throws SQLException {
		ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("application.xml");
		TestController tc = (TestController) application.getBean("testController");
		System.out.println(tc.getDataSource().getClass().getPackage());
		System.out.println(tc.getDataSource().getConnection());


	}

}

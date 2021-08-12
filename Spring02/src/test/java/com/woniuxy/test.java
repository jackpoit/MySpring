package com.woniuxy;

import com.woniuxy.controller.UserController;
import com.woniuxy.dao.UserDao;
import com.woniuxy.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: rua
 * @Date: 2021/8/12 10:20
 * @Description:
 */
public class test {

	@Test
	public void annotationTest01(){
		ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("application.xml");
		UserDao userDao = (UserDao) application.getBean("userDao");
		userDao.add();
	}
	@Test
	public void annotationTest02(){
		ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("application.xml");
		UserService userService = (UserService) application.getBean("userService");
		userService.add();
	}

	@Test
	public void annotationTest03(){
		ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("application.xml");
		UserController uc = (UserController) application.getBean("userController");
		uc.add();
	}
	@Test
	public void annotationTest04(){
		ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("application.xml");
		UserController uc = (UserController) application.getBean("userController");
		uc.add();
		System.out.println(uc.getId());
	}
}

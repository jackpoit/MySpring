package com.woniuxy.test;

import com.woniuxy.ApplicationConfig;
import com.woniuxy.entity.Car;
import com.woniuxy.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.annotation.Resources;

/**
 * @Author: rua
 * @Date: 2021/8/14 23:09
 * @Description:
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
//@ContextConfiguration(classes = {ApplicationConfig.class})
public class TestDemo {

	@Autowired
	private User user;

//	@Autowired
//	private User user2;


	//	@Autowired
//	@Qualifier("car2") //先按照名称car2去spring工厂查id,查到后由@Autowired 实现自动装配
	@Resource(name = "car1") //@Resource(name = "car1")==@Autowired +@Qualifier("car2")
	private Car car;

	@Test
	public void demo() {
//		System.out.println(user==user2);
		System.out.println(user);
		System.out.println(car);
	}
}

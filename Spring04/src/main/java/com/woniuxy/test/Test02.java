package com.woniuxy.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: rua
 * @Date: 2021/8/16 10:49
 * @Description:
 */

public class Test02 {

	@Test
	public void  test02(){

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
		System.out.println(applicationContext);
	}

}

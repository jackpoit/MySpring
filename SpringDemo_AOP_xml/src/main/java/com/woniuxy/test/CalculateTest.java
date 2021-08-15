package com.woniuxy.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @Author: rua
 * @Date: 2021/8/15 21:49
 * @Description:
 */
public class CalculateTest {

	public int add(int a, int b){
		System.out.println("加法业务核心逻辑");
		return a+b;
	}

	public static void main(String[] args) {
		Log log = LogFactory.getLog(CalculateTest.class);
		int a=10;
		int b=20;
		log.info("参数a="+a+",b="+b);
		int result=new CalculateTest().add(a,b);//核心业务逻辑
		log.info(a+"+"+b+"="+result);
	}
}

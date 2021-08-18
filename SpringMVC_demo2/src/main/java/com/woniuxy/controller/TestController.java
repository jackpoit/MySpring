package com.woniuxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: jackpoit
 * 后端处理器
 * @RequestMapping
 * 		path: 以前的url-pattern 路由
 *		method=RequestMethod.GET/POST 限定请求方式[不设置这个属性是:任意请求方式都可以接受,开发中要去请求必须明确写出]
 *		params = {"name","!age"}:请求中必须携带name/不能携带age 请求参数
 *		headers = {"User-Agent"} //请求体必须携带User-Agent/不能携带,反爬虫
 *
 */
@Controller //IOC (会让这个类实现Controller接口)
@RequestMapping(path = "/test")//父路由[类路由] (可以不加'/',底层会给你加)
public class TestController  {

	@RequestMapping("/demo1")//注解映射的路由
	public String test01(){
		System.out.println("testController执行了demo1");

		return "success";
	}

	@RequestMapping(value = "/demo2",method = RequestMethod.POST)
	public String test02(){
		System.out.println("testController执行了demo2");

		return "success";
	}

	@RequestMapping(value = "/demo3",params = {"name","!age"},headers = {"User-Agent"})
	public String test03(){
		System.out.println("testController执行了demo3");

		return "success";
	}
}

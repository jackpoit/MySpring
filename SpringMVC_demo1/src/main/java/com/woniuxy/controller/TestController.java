package com.woniuxy.controller;

/**
 * @Author: rua
 * @Date: 2021/8/16 0:30
 * @Description:
 */

import com.woniuxy.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * POJO:java老对象[普通的java类]
 */
@Controller  //IOC
public class TestController {

	@RequestMapping("/test")
	public String test(HttpServletRequest req){
//		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//		viewResolver.setPrefix("");
//		viewResolver.setSuffix("html");

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println(username+":"+password);
		return "success"; //默认安装转发返回的
	}


	@RequestMapping("/test2")
	public String test2(String username,String password){
		System.out.println(username+":"+password);
		return "success"; //默认安装转发返回的
	}
	@RequestMapping("/test3")
	public String test3(User user, Map<String,Object> map){
		System.out.println(user);
		map.put("user",user);
		return "success"; //默认安装转发返回的
	}

}

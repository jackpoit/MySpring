package com.woniuxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: rua
 * @Date: 2021/8/21 16:30
 * @Description:
 */
@Controller
@RequestMapping("/test")
public class TestController {


	@RequestMapping("demo")
	public String demo(){
		int a=10/0;
		System.out.println("test执行了demo()");
		return "success";
	}
}

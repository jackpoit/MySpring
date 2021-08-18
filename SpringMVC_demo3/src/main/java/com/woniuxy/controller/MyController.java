package com.woniuxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: rua
 * @Date: 2021/8/19 0:47
 * @Description:
 */
@Controller
@RequestMapping("my")
public class MyController {

	@RequestMapping("test")
	public String demo(){
		System.out.println("MyController执行了demo()");
		return "success";
	}
}

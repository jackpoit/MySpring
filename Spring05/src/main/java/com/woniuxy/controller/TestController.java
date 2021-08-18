package com.woniuxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: rua
 * @Date: 2021/8/16 14:12
 * @Description:
 */
@Controller
public class TestController {

	@RequestMapping("/code500")
	public String code500() {
		System.out.println(500);
		return "error/500";
	}

	@RequestMapping("/code404")
	public String code404() {
		System.out.println(404);
		return "error/404";
	}

	//	重定向:springMVC 在controller进行重定向使用 redirect
	@RequestMapping("/test01")
	public String test01() {

		return "redirect:WEB-INF/success.html";
	}

	//	转发:springMVC 在controller进行转发 使用 forward
//	方式1进行转发:(执行视图解析器)
	@RequestMapping("/test02")
	public String test02() {
		return "success";//默认采用的是转发 (走视图解析器)
	}

	//	方式2进行转发:(不会执行视图解析器)
	@RequestMapping("/test03")
	public String test03() {
		return "forward:WEB-INF/success.html";
	}

	@RequestMapping("/interceptor01")
	public String inter01() {
		System.out.println("interceptor01");
		return "index";
	}

	@RequestMapping("/loginUser")
	public String login(String userName, String userPass, HttpServletRequest req) {

		if ("admin".equals(userName) && "admin".equals(userPass)) {
			HttpSession session = req.getSession();
			session.setAttribute("username",userName);
			return "success";
		}
		return "redirect:login.html";
	}

	@RequestMapping("/register")
	public String register() {
		System.out.println("register");
		return "index";
	}
	@RequestMapping("/getSuccess")
	public String getSuccess() {
		System.out.println("getSuccess");
		return "success";
	}

	@RequestMapping("restful/{id}/{userName}/{userPass}")
	public String getRestful(@PathVariable("id") Integer id, @PathVariable("userName") String userName, @PathVariable("userPass") String userPass){

		System.out.println(id+","+userName+","+userPass);
		return "redirect:/index.html";
	}
}

package com.woniuxy.controller;

import com.alibaba.fastjson.JSON;
import com.woniuxy.domain.JsonData;
import com.woniuxy.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @Author: jackpoit
 *
**/
@Controller //IOC (会让这个类实现Controller接口)
@RequestMapping("ajax")
public class TestController  {

	//使用原生态的servletAPI完成ajax请求的获取和响应
	@RequestMapping("test1")
	public void demo01(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		System.out.println(uname+":"+pwd);
//		return "success"; //默认是逻辑视图名,视图解析器解析成物理视图
//		String jsonStr= "{\"pid\":1,\"price\":666}";
		ArrayList<User> list = new ArrayList<>();
		list.add(new User(1,"jack","啦啦啦"));
		list.add(new User(2,"json","啦啦哈哈哈啦"));
		String jsonString = JSON.toJSONString(list);
		resp.getWriter().write(jsonString);
	}

	@RequestMapping("test2")
	public void demo02(HttpServletResponse resp,User user) throws IOException {
		System.out.println(user);

		ArrayList<User> list = new ArrayList<>();
		list.add(new User(1,"jack","啦啦啦"));
		list.add(new User(2,"json","啦啦哈哈哈啦"));
		String jsonString = JSON.toJSONString(list);
		resp.getWriter().write(jsonString);
	}

	/**
	 * 前提:设置请求体编码
	 * contentType:"application/json;charset=utf-8",
	 *  @RequestBody 用来绑定请求体的参数(一般处理的都是json字符串)
	 *
	 */
	@RequestMapping("test3")
	public void demo03(HttpServletResponse resp, @RequestBody String str) throws IOException {
		System.out.println(str);
		//json字符串-->java对象
		User user = JSON.parseObject(str, User.class);
		System.out.println(user);

		ArrayList<User> list = new ArrayList<>();
		list.add(new User(1,"jack","啦啦啦"));
		list.add(new User(2,"json","啦啦哈哈哈啦"));
		String jsonString = JSON.toJSONString(list);
		resp.getWriter().write(jsonString);
	}

	/**
	 * SpringMVC中对于json的处理默认采用了jackson框架来处理
	 */
	@RequestMapping("test4")
	public void demo04(HttpServletResponse resp, @RequestBody User user) throws IOException {

		System.out.println(user);

		ArrayList<User> list = new ArrayList<>();
		list.add(new User(1,"jack","啦啦啦"));
		list.add(new User(2,"json","啦啦哈哈哈啦"));
		String jsonString = JSON.toJSONString(list);
		resp.getWriter().write(jsonString);
	}

	//使用SpringMVC默认的jackson来处理json返回值
	//jackson中默认处理了中文
	@ResponseBody //处理的响应体的内容 [不会再经过默认的视图解析器,而是直接返回内容]
	@RequestMapping("test5")
	public Object demo05() {

		return new JsonData(1,"文件上传成功","测试.doc");
	}

	//使用SpringMVC默认的jackson来处理json返回值
	@ResponseBody //处理的响应体的内容 [不会再经过默认的视图解析器,而是直接返回内容]
	@RequestMapping("test6")
	public User demo06() {

		return new User(1,"jack","杰克");
	}

}

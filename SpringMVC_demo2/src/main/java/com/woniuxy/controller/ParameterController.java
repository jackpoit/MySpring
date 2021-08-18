package com.woniuxy.controller;

import com.woniuxy.domain.Bean;
import com.woniuxy.domain.Model51;
import com.woniuxy.domain.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author: jackpoit
 * 后端处理器
 *
 */
@Controller //IOC (会让这个类实现Controller接口)
@RequestMapping("param")//父路由[类路由]
public class ParameterController {

	//开发几乎不用,使用传统的ServletAPI接口
	@RequestMapping("/servlet_api")//注解映射的路由
	public String demo1(HttpServletRequest req){
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		System.out.println(uname+":"+pwd);
		return "success";
	}

	//400-->参数绑定错误

	//约定优于编程(参数绑定)
	@RequestMapping("/test1")//注解映射的路由
	public String demo2(String uname,String pwd,Float salary){
		System.out.println(uname+":"+pwd+","+salary);
		return "success";
	}

	//约定优于编程(参数绑定)
	@RequestMapping(value = "/test2",method = RequestMethod.POST)//注解映射的路由
	public String demo3(@DateTimeFormat(pattern = "yyyy-MM-dd") Date birthday){ //需要给特殊格式的类型转换定制一个类型转换器

		System.out.println(birthday);

		return "success";
	}

	@RequestMapping(value = "/test3",method = RequestMethod.POST)//注解映射的路由
	public String demo4(User user){ //需要给特殊格式的类型转换定制一个类型转换器
		//SpringMVC并没有处理请求乱码,tomcat9默认处理了get请求乱码
		//post请求乱码了:post请求参数都存放在请求体中
		//		req.setCharacterEncoding("UTF-8"); //Spring在整合web项目是提供了编码处理过滤器
		System.out.println(user);
		return "success";
	}

	@RequestMapping(value = "/test4",method = RequestMethod.POST)//注解映射的路由
	public String demo5(Bean bean){
//	public String demo6(@RequestParam("list") ArrayList<User> list){//不行
		//无uname pwd的get set方法 值取不到

		List<User> list = bean.getList();
		if (list!=null){
			for (User user : list) {
				System.out.println(user);
			}
		}
		return "success";
	}

	/**
	 * 	@RequestParam("list")
	 * 			绑定请求参数的
	 * 			实现代码混淆[参数不想让别人看懂]
	 */
	@RequestMapping(value = "/test5")//注解映射的路由
//	public String demo6(String[] hobbys){
	public String demo6(String... hobbys){
		System.out.println(Arrays.toString(hobbys));
		return "success";
	}

	@RequestMapping(value = "/test6")//注解映射的路由
	public String demo7(@RequestParam(name = "a") String uname,@RequestParam("b") String pwd,@RequestParam("c") Integer gender){

		System.out.println("uname:"+uname+"pwd:"+pwd+"gender:"+gender);
		return "success";
	}

	/**
	 * @RequestParam(name = "page",required = true)
	 * 		name="page" 与前端约定好的名称
	 * 		required=true [默认为true]参数必须出现在请求参数中
	 */
	@RequestMapping("/one_page")
	public String demo8(@RequestParam(name = "page",required = false,defaultValue = "1") Integer currentPage){
		System.out.println(currentPage);
		return "success";
	}
	/**
	 * restful风格
	 * 语法:{}
	 * 表现层的状态映射
	 */
	@RequestMapping("/test7/{uname}/{pwd}/{gender}")
	public String demo9(@PathVariable String uname,@PathVariable String pwd ,@PathVariable Integer gender){
		System.out.println("uname:"+uname+"pwd:"+pwd+"gender:"+gender);
		return "success";
	}

	//param/list/020000,java,2?lang=php
	@RequestMapping("/list/{city},{kw},{page}")
	public String demo10(@PathVariable String city,
						 @PathVariable("kw") String keyword ,
						 @PathVariable("page") Integer currentPage,String lang){
		System.out.println("区号:"+city+"关键字:"+keyword+"当前页码:"+currentPage+"语言:"+lang);
		return "success";
	}

	//param/one/020000,java,2?lang=php
	@RequestMapping("/one/{city},{kw},{page}")
	public String demo11(@PathVariable String city,
						 @PathVariable("kw") String keyword ,
						 @PathVariable("page") Integer currentPage, Model51 bean){
		bean.setCode(city);
		bean.setKeyword(keyword);
		bean.setCurrentPage(currentPage);
		System.out.println(bean);
		return "success";
	}
}

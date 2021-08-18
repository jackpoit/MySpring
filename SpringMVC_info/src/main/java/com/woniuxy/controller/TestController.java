package com.woniuxy.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: jackpoit
 * 处理器的创建
 * 		1.类 实现Controller
 * 		2.重写handleRequest()
 * 		3.将处理器交给Spring容器管理
 */

public class TestController implements Controller {

	/**
	 * handleRequest:处理器处理请求的方法(类似于以前Servlet中的service()方法)
	 * ModelAndView: 模型视图[业务模型数据  View:渲染页面]
	 *
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
		System.out.println("TestController进来了");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/admin/admin.html"); //完整的物理视图路径
		// WEB-INF/这个目录对于客户端来说是访问受限的

		mv.setViewName("admin/admin"); //逻辑视图名
		mv.addObject("msg","helloMVC");//将模型数据放入request域中

		return mv;
	}
}

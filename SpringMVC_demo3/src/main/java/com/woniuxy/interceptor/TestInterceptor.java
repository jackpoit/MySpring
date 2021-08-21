package com.woniuxy.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: rua
 * 定义一个拦截器
 * 1.类implements HandlerInterceptor
 * 2.重写3个拦截方法
 * 3.在SpringMVC中配置拦截器
 *
 *
 */

public class TestInterceptor implements HandlerInterceptor {

	//在调用handler[Controller]之前执行
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("TestInterceptor执行了preHandle方法");
		response.setContentType("text/html;charset=utf-8");


//		return false;//false:不会放行到Controller[应用:登录拦截]
		return true; //条件满足时放行到Controller
	}

	//在执行完Controller之后拦截的方法
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
		System.out.println("TestInterceptor执行了postHandle方法");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		System.out.println("TestInterceptor执行了afterCompletion方法");

	}
}

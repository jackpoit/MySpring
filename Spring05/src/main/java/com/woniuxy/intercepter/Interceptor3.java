package com.woniuxy.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: rua
 * @Date: 2021/8/16 15:25
 * @Description:
 */
public class Interceptor3 implements HandlerInterceptor {

	//1.执行controller之前执行
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("pre.....interceptor....3");
		return true;
	}

	//2.执行controller之后,还没来得及渲染界面执行
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		System.out.println(("post.....interceptor....3"));
	}


	//3.渲染完页面之后 执行
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		System.out.println(("after.....interceptor....3"));

	}
}

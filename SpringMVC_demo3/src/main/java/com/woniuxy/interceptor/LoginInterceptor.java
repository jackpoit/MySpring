package com.woniuxy.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author: rua
 * @Date: 2021/8/19 1:23
 * @Description:
 */
public class LoginInterceptor implements HandlerInterceptor {

	//先拦截 可以避免404 是对过滤器的优化
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("LoginInterceptor执行了preHandle方法");

		/**
		 * 分开权限的2种方法:
		 * 		1.session中放不同的值,写2个拦截器
		 * 		2.下面从session中若能去到,查看status 0/1再分权限
		 */
		//判断是否登录
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("user") == null) {
			response.getWriter().write("<script>alert('未登录不能访问')</script>");
			String path = request.getContextPath();
			response.setHeader("refresh", "0;url=" + path + "/view/login");
			return false;
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		System.out.println("LoginInterceptor执行了postHandle方法");

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		System.out.println("LoginInterceptor执行了afterCompletion方法");

	}
}

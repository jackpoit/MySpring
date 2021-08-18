package com.woniuxy.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author: rua
 * @Date: 2021/8/16 16:08
 * @Description:
 */
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
			response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession(false);
		if (session!=null&&session.getAttribute("username")!=null){
			return true;
		}else{
			response.getWriter().write("<script>alert('请先登录');location.href='/login.html'</script>");
		}
		return false;
	}
}

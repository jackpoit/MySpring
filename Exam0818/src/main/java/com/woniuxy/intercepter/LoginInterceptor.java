package com.woniuxy.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession(false);
        if(session!=null&& session.getAttribute("userName")!=null){
            return true;
        }else{
            response.getWriter().write("<script>alert('请先登录...');window.location.href='/index.html';</script>");
        }
        return false;
    }
}

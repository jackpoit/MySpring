package com.woniuxy.controller;


import com.woniuxy.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * @Author: rua
 * @Date: 2021/8/21 16:30
 * @Description:
 */
@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	@RequestMapping("/login")
	public String login(String userNo, String userPass) {

		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(userNo, userPass);

		try {
			subject.login(token);
			return "main";
		} catch (UnknownAccountException e) {
			System.err.println("用户名错误");
		} catch (IncorrectCredentialsException e) {
			System.err.println("密码错误");
		} catch (AuthenticationException e) {
			System.err.println("其他异常");
		}

		return "login";
	}
}

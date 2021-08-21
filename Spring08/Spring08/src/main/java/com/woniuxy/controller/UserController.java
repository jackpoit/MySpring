package com.woniuxy.controller;

import com.woniuxy.bean.User;
import com.woniuxy.service.UserService;
import com.woniuxy.util.PassUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

/**
 * @Author: rua
 * @Date: 2021/8/19 11:03
 * @Description:
 */
@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/userLogin")
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

	@RequestMapping("register")
	public String register(User user) {
		user.setSaltValue(UUID.randomUUID().toString().replace("-", ""));
		user.setCount(1023);
		String codePass = PassUtil.getHashPass("MD5", user.getUserPass(), user.getSaltValue(), 1023);
		user.setCodePass(codePass);
		int row = userService.doRegister(user);
		System.out.println(row==1?"成功":"失败");
		return "index";
	}



}



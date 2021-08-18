package com.woniuxy.controller;

import com.woniuxy.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Author: rua
 * @Date: 2021/8/19 1:08
 * @Description:
 */
@Controller
@RequestMapping("user")
public class UserController {

	@RequestMapping("login")
	public String login(User user, HttpSession session) {
		if (session == null)
			return "login";

		if ("admin".equals(user.getUname()) && "123".equals(user.getPwd()) && user.getStatus() == 1) {
			session.setAttribute("user", user);
			return "admin/index";
		}
		if ("jack".equals(user.getUname()) && "111".equals(user.getPwd()) && user.getStatus() == 0) {
			session.setAttribute("user", user);
			return "user/index";
		}
		if ("rose".equals(user.getUname()) && "222".equals(user.getPwd()) && user.getStatus() == 0) {
			session.setAttribute("user", user);
			return "user/index";

		}
		return "login";
	}

	@RequestMapping("center")
	public String userCenter(){
		//
		return "user/center";
	}
}

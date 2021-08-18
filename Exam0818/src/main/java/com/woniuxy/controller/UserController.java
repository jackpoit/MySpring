package com.woniuxy.controller;

import com.woniuxy.bean.User;
import com.woniuxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: rua
 * @Date: 2021/8/18 11:38
 * @Description:
 */
@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping("login")
	public String login(HttpServletRequest req, User user) {

		User result = userService.doLogin(user);
		if (result!=null){
			HttpSession session = req.getSession();
			session.setAttribute("userName",result.getUserName());
		}
		return result!=null?"Y":"N";
	}
	@ResponseBody
	@RequestMapping("register")
	public String register(User user) {

		boolean flag = userService.doAdd(user);

		return flag?"Y":"N";
	}

}

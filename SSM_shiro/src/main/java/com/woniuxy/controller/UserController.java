package com.woniuxy.controller;


import com.woniuxy.service.UserService;
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

	@RequestMapping("findAll")
	public ModelAndView findAll(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("success");
		mv.addObject("list",userService.findAll());
		return mv;
	}
}

package com.woniuxy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: rua
 * @Date: 2021/8/18 23:56
 * @Description:
 */
@Controller
@RequestMapping("exp")
public class TestExceptionController {


	@RequestMapping("/test")
	public String demo1() {
		String str = null;
		str.length();
		return "success";
	}

	//就近原则 类中有处理方法 就用类中的exceptionHandler
	//没有的再去全局exceptionHandler中处理
	//专门用于处理异常的方法 (只能处理本类的异常)
	@ExceptionHandler({NullPointerException.class, ArithmeticException.class})
	public ModelAndView handleException(Throwable e) {
		ModelAndView mv = new ModelAndView("exception");
		System.out.println(e.getMessage());
		mv.addObject("msg",e.getClass()+"-->"+ e.getMessage());
		return mv;
	}
}

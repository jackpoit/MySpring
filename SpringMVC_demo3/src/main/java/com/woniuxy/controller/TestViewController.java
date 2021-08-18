package com.woniuxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: jackpoit
 * @Date: 2021/08/18/16:42
 * @Description:
 */
@Controller
@RequestMapping("test_view")
public class TestViewController {

	@RequestMapping("string")
	public String demo1() {
//		return "/WEB-INF/success.jsp";
		return "success"; //逻辑视图名 (返回string默认转发)
	}

	@RequestMapping("mv")
	public ModelAndView demo2() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("success");
		return mv;
	}

	@RequestMapping("forward")
	public String demo3() {
//		return "forward:/WEB-INF/success.jsp";
//		return "forward:/success.jsp";
		return "forward:/test_view/mv";
	}

	@RequestMapping("redirect")
	public String demo4() {
//		return "redirect:/test_view/mv"; //重定向方式()
//		return "redirect:/success.jsp";
//		return "redirect:/WEB-INF/success.jsp"; //无法重定向到WEB-INF (受保护)
		return "redirect:/view/success"; //解决方案:重定向到另一个controller
	}

	//如何向页面传参
	@RequestMapping("param1")
	public String demo5(HttpServletRequest req) {
		req.setAttribute("msg", "Servlet-api");//向request域中存放键值对
		return "success";//默认转发
	}

	@RequestMapping("param2")
	public String demo6(Map<String,Object> map) {
		map.put("msg","map传参"); //map传参
		return "success";//默认转发
	}

	@RequestMapping("param3")
	public String demo7(ModelMap map) { //模型数据map
		map.put("msg","ModelMap传参");
		return "success";//默认转发
	}

	@RequestMapping("param4")
	public ModelAndView demo8() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("success");
		mv.addObject("msg","ModelAndView传参");
		return mv;
	}

	/**
	 * 无论是String还是Map,ModelMap 最终都会封装成一个ModelAndView对象
	 * 	并且将model中的模型数据默认存放在request域中的,请求默认都是转发(request域不会消失)
	 */
}

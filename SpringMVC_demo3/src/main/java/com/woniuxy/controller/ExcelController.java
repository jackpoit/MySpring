package com.woniuxy.controller;

import com.woniuxy.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: jackpoit
 * @Date: 2021/08/18/20:09
 * @Description:
 */
@Controller
@RequestMapping("excel")
public class ExcelController {

	@RequestMapping("download_excel")
	public ModelAndView getDate(){
		ModelAndView mv = new ModelAndView();
		ArrayList<User> list = new ArrayList<>();
		list.add(new User(1,"jack","杰克"));
		list.add(new User(2,"tom","汤姆"));
		list.add(new User(3,"jerry","杰瑞"));
		list.add(new User(4,"rose","路西"));
		mv.setViewName("excelView"); //将来视图解析器需要真正映射的模板名称
		mv.addObject("data",list);
		return mv;
	}
}

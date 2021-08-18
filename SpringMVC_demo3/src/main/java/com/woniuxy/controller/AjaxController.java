package com.woniuxy.controller;

import com.woniuxy.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 *当这个类每个请求都是ajax请求都是
 * :@RestController :不会通过视图解析器来解析了
 */
//@ResponseBody
//@Controller
@RestController //@RestController=@Controller+@ResponseBody
@RequestMapping("test")
public class AjaxController {

//	@ResponseBody //不会以视图解析器方式来运行,以正常文档流方式来
//	(同步异步都可以,只不过同步会把返回的内容直接输出到页面)
	@RequestMapping("ajax1")
	public String testAjax1(){
		int a=10/0;

		//返回字符串不会转成json 前端也不能用dataType:json去接收
		int row=1;
		return row==0?"ok":"no";
	}

//	@ResponseBody
	@RequestMapping("ajax2")
	public User testAjax2(){
		return new User(1,"jack","杰克");
	}

//	@ResponseBody
	@RequestMapping("ajax3")
	public List<User> testAjax3(){
		ArrayList<User> list = new ArrayList<>();
		list.add(new User(1,"jack","啦啦啦"));
		list.add(new User(2,"json","啦啦哈哈哈啦"));
		return list;
	}

	//	@ResponseBody
	@RequestMapping("ajax4")
	public Object testAjax4(){
		ArrayList<User> list = new ArrayList<>();
		list.add(new User(1,"jack","啦啦啦"));
		list.add(new User(2,"json","啦啦哈哈哈啦"));
		return list;
	}

}

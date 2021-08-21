package com.woniuxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: jackpoit
 * @Date: 2021/08/18/16:56
 *
 * 通用的页面跳转
 *
 */
@Controller
@RequestMapping("/view")
public class ViewController {

	@RequestMapping("/{path}")
	public String gotoView(@PathVariable String path){
		return path;
	}

	@RequestMapping("/{dir}/{path}")
	public String gotoView(@PathVariable String dir,@PathVariable String path){
		return dir+"/"+path;
	}

}

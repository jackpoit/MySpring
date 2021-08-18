package com.woniuxy.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.bean.App;
import com.woniuxy.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: jackpoit
 * @Date: 2021/08/18/9:47
 * @Description:
 */
@RestController
@RequestMapping("/app")
public class AppController {

	@Autowired
	private AppService appService;

	@RequestMapping("query")
	public PageInfo<App> queryApp(@RequestParam(name = "nowPage",required = false,defaultValue = "1") Integer currentPage, App app) {
		System.out.println(app);
		PageInfo<App> info = appService.showByKeyword(currentPage, app);
		return info;
	}

	@RequestMapping("delete")
	public String deleteApp(String[] ids) {

		Integer[] aids = new Integer[ids.length];
		for (int i = 0; i < ids.length; i++) {
			if (ids[i] != null) {
				aids[i] = Integer.parseInt(ids[i]);
			}
		}
		boolean flag = appService.doDelete(aids);
		return flag?"Y":"N";
	}

	@RequestMapping("add")
	public String addApp(App app) {

		app.setAppCount(0);
		boolean flag = appService.doAdd(app);
		return flag ? "Y" : "N";

	}

	@RequestMapping("update")
	public String updateApp(App app)  {
		boolean flag = appService.doUpdate(app);
		return flag ? "Y" : "N";

	}

}

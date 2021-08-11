package com.woniuxy.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.bean.App;
import com.woniuxy.service.AppService;
import com.woniuxy.util.BaseServlet;
import com.woniuxy.util.UpLoadUtil;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: rua
 * @Date: 2021/8/11 17:02
 * @Description:
 */
@MultipartConfig
@WebServlet("/appController")
public class AppController extends BaseServlet {
	private AppService asi;

	{
		ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("application.xml");
		asi = (AppService) application.getBean("appService");
	}

	public void queryApp(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		PageHelper.startPage(1, 5);
		List<App> list = asi.queryApp();
		PageInfo<App> info = new PageInfo<>(list);
		resp.getWriter().write(JSON.toJSONString(info));
	}

	public void deleteApp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idStr = req.getParameter("id");
		String status = "0";
		if (idStr != null && !"".equals(idStr)) {
			int id = Integer.parseInt(idStr);
			if (asi.deleteApp(id) > 0) {
				status = "1";
			}
		}
		resp.getWriter().write(status);
	}

	public void addApp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		App app = new App();
		app.setAppName(req.getParameter("appName"));
		app.setAppType(req.getParameter("appType"));
		app.setAppPlatform(req.getParameter("appPlatform"));
		app.setAppSize(Integer.parseInt(req.getParameter("appSize")));
		app.setAppCount(0);
		app.setAppImg(UpLoadUtil.up("appImg", "app", req));
		resp.getWriter().write(asi.addApp(app) > 0 ? "1" : "0");
	}

	public void updateApp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(111);
		App app = new App();
		app.setId(Integer.parseInt(req.getParameter("id")));
		app.setAppName(req.getParameter("appName"));
		app.setAppType(req.getParameter("appType"));
		app.setAppPlatform(req.getParameter("appPlatform"));
		app.setAppCount(Integer.parseInt(req.getParameter("appCount")));
		app.setAppSize(Integer.parseInt(req.getParameter("appSize")));
		app.setAppImg(UpLoadUtil.up("appImg", "app", req));

		resp.getWriter().write(asi.updateApp(app) > 0 ? "1" : "0");
	}

}

package com.woniuxy.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.bean.App;
import com.woniuxy.service.AppService;
import com.woniuxy.util.BaseServlet;
import com.woniuxy.util.UpLoadUtil;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

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
@Controller("appController")
@MultipartConfig
@WebServlet("/appController")
@Data
public class AppController extends BaseServlet {

	@Autowired
	@Qualifier("appService")
	private AppService asi;

	public void queryApp()  {
		List<App> list = asi.queryApp();
		System.out.println(list);
	}

	public void deleteApp(int id)  {
		System.out.println(asi.deleteApp(id));

	}

	public void addApp(App app) {

		System.out.println(asi.addApp(app));
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

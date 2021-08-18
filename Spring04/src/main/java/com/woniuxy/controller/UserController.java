package com.woniuxy.controller;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.woniuxy.bean.Good;
import com.woniuxy.bean.User;
import com.woniuxy.service.UserService;
import com.woniuxy.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;


/**
 * @Author: rua
 * @Date: 2021/8/10 18:48
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService usi;

	@RequestMapping("/showPage")
	public PageInfo<User> showPage(HttpServletRequest req) {

		String currentUserPageStr = req.getParameter("currentPage");
		int currentUserPage = 1;
		if (!StringUtil.isEmpty(currentUserPageStr)) {
			currentUserPage = Integer.parseInt(currentUserPageStr);
		}

		Integer id = null;
		String idStr = req.getParameter("uid");
		if (!StringUtil.isEmpty(idStr)) {
			id = Integer.parseInt(idStr);
		}
		String username = req.getParameter("uname");
		if (username == null) {
			username = "";
		}
		String mobile = req.getParameter("uphone");
		if (mobile == null) {
			mobile = "";
		}

		return usi.findOnePage(currentUserPage, id, username, mobile);
	}

	@RequestMapping("/delete")
	public String deleteByIds(HttpServletRequest req)  {

		String[] uids = req.getParameterValues("ids");
		Integer[] ids = new Integer[uids.length];
		for (int i = 0; i < ids.length; i++) {
			if (uids[i] != null) {
				ids[i] = Integer.parseInt(uids[i]);
			}
		}
		boolean flag = usi.doDelete(ids);
		return flag ? "Y" : "N";
	}

	@RequestMapping("/edit")
	public String edit(User user) throws Exception {
		System.out.println(user);
		String password = user.getPassword();
		if (!StringUtil.isEmpty(password)) {
			user.setMd5Code(MD5Util.getMd5(password, "com.woniuxy"));
		}
		user.setGender("男");
		user.setLevel(0);
		user.setUType(0);


		boolean flag = usi.doUpdate(user);

		return flag ? "Y" : "N";

	}

	@RequestMapping("/add")
	public String add(User user) throws Exception {
		System.out.println(user);

		String password = user.getPassword();
		if (!StringUtil.isEmpty(password)) {
			user.setMd5Code(MD5Util.getMd5(password, "com.woniuxy"));
		}
		user.setGender("男");
		user.setLevel(0);
		user.setUType(0);

		boolean flag = usi.doRegister(user);
		return flag ? "Y" : "N";
	}

	@RequestMapping("/test")
	public String test(Good good){
		System.out.println(good);
		return "index";
	}

}

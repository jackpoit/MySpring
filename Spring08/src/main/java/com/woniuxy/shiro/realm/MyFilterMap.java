package com.woniuxy.shiro.realm;

import com.woniuxy.bean.Permission;
import com.woniuxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: rua
 * @Date: 2021/8/20 12:00
 * @Description:
 */
public class MyFilterMap {

	@Autowired
	private UserService userService;

	public Map<String, String> getMap() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("/login.jsp", "anon");
		map.put("/userLogin", "anon");
		map.put("/register.jsp", "anon");
		map.put("/register", "anon");
		map.put("/css/**", "anon");
		map.put("/fonts/**", "anon");
		map.put("/images/**", "anon");
		map.put("/img/**", "anon");
		map.put("/js/**", "anon");

		map.put("/logout", "logout");

		List<Permission> list = userService.getAllPermission();
		for (Permission permission : list)
			map.put(permission.getPermissionName(), "roles[" + permission.getRole().getRoleName() + "]");


		map.put("/**", "authc");
		return map;
	}

}

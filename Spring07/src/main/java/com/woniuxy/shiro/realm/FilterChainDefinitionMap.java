package com.woniuxy.shiro.realm;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: rua
 * @Date: 2021/8/20 9:46
 * @Description:
 */
public class FilterChainDefinitionMap {


	public  Map<String, String> getMap() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("/index.jsp", "anon");
		map.put("/login", "anon");
		map.put("/register", "anon");
		map.put("/logout", "logout");
		map.put("/page/add.jsp", "roles[manager]");
		map.put("/page/list.jsp", "roles[user]");
		return map;
	}
}

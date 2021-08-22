package com.woniuxy.service;

import com.woniuxy.bean.Permission;
import com.woniuxy.bean.User;

import java.util.List;
import java.util.Set;

public interface UserService {

	User doLogin(String userNo);

	int doRegister(User user);

	List<Permission> getAllPermission();

	Set<String> getRolesByNo(String userNo);

}

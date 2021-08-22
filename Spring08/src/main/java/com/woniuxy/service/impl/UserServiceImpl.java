package com.woniuxy.service.impl;

import com.woniuxy.bean.Permission;
import com.woniuxy.bean.User;
import com.woniuxy.mapper.PermissionMapper;
import com.woniuxy.mapper.UserMapper;
import com.woniuxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @Author: rua
 * @Date: 2021/8/19 16:02
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private PermissionMapper permissionMapper;

	@Override
	public User doLogin(String userNo) {

		return userMapper.login(userNo);
	}

	@Override
	public int doRegister(User user) {
		return userMapper.add(user);
	}

	@Override
	public List<Permission> getAllPermission() {

		return permissionMapper.getAllPermission();
	}

	@Override
	public Set<String> getRolesByNo(String userNo) {
		Set<String> set = userMapper.getRolesByNo(userNo);
		System.out.println(set);
		return set;
	}
}

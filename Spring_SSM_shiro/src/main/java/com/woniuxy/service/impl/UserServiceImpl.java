package com.woniuxy.service.impl;

import com.woniuxy.bean.Permission;
import com.woniuxy.bean.User;
import com.woniuxy.bean.UserRole;
import com.woniuxy.dao.PermissionMapper;
import com.woniuxy.dao.RoleMapper;
import com.woniuxy.dao.UserMapper;
import com.woniuxy.dao.UserRoleMapper;
import com.woniuxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Author: rua
 * @Date: 2021/8/21 16:58
 * @Description: 实现类
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private PermissionMapper permissionMapper;

	@Override
	public User doLogin(String username) {
		User user = new User();
		user.setUsername(username);
		return userMapper.selectOne(user);
	}

	@Override
	public List<Permission> getUserPermissions(Integer uid) {

		return permissionMapper.getUserPermissions(uid);
	}


}

package com.woniuxy.service.impl;

import com.woniuxy.bean.Permission;
import com.woniuxy.dao.PermissionMapper;
import com.woniuxy.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: rua
 * @Date: 2021/8/22 22:08
 * @Description:
 */
@Service
public class PermissionServiceImpl implements PermissionService {
	@Autowired
	private PermissionMapper permissionMapper;
	@Override
	public List<Permission> getAllPermissions() {
		Permission permission = new Permission();
		permission.setType("menu");
		return permissionMapper.select(permission);
	}
}

package com.woniuxy.mapper;

import com.woniuxy.bean.Permission;
import com.woniuxy.bean.User;

import java.util.List;

public interface PermissionMapper {

	List<Permission> getAllPermission();


	String getPermissionName(Integer id);
	Permission getPermission(Integer id);

}

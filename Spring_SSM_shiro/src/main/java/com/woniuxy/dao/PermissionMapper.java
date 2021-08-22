package com.woniuxy.dao;

import com.woniuxy.bean.Permission;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PermissionMapper extends Mapper<Permission> {

	List<Permission> getUserPermissions(Integer uid);

}

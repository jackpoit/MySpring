package com.woniuxy.mapper;

import com.woniuxy.bean.User;

import java.util.List;
import java.util.Set;

public interface UserMapper {
	//根据账号查对象
	User login(String userNo);

	int add(User user);


	Set<String> getRolesByNo(String userNo);
}

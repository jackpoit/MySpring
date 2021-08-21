package com.woniuxy.mapper;

import com.woniuxy.bean.User;

public interface UserMapper {
	//根据账号查对象
	User login(String userNo);

	int add(User user);
}

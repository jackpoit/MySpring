package com.woniuxy.service;

import com.woniuxy.bean.User;

public interface UserService {

	User doLogin(String userNo);

	int doRegister(User user);
}

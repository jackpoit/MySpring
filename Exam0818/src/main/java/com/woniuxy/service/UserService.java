package com.woniuxy.service;

import com.woniuxy.bean.User;

/**
 * @Author: rua
 * @Date: 2021/8/18 12:09
 * @Description:
 */
public interface UserService {

	boolean doAdd(User user);
	User doLogin(User user);
}

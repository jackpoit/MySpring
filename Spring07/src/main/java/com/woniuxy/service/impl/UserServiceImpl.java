package com.woniuxy.service.impl;

import com.woniuxy.bean.User;
import com.woniuxy.mapper.UserMapper;
import com.woniuxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: rua
 * @Date: 2021/8/19 16:02
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User doLogin(String userNo) {

		return userMapper.login(userNo);
	}

	@Override
	public int doRegister(User user) {
		return  userMapper.add(user);
	}
}

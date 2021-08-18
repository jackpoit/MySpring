package com.woniuxy.service.impl;

import com.woniuxy.bean.User;
import com.woniuxy.mapper.UserMapper;
import com.woniuxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: rua
 * @Date: 2021/8/18 12:09
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Override
	public User doLogin(User user) {
		if (user==null)
			return null;
		List<User> list = userMapper.findByCondition(user);

		return list.size()==1?list.get(0):null;
	}
}

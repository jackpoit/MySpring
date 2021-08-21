package com.woniuxy.service.impl;

import com.woniuxy.bean.User;
import com.woniuxy.dao.UserMapper;
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
	@Override
	public List<User> findAll() {

		return userMapper.findAll();
	}
}

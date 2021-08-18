package com.woniuxy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.woniuxy.bean.User;
import com.woniuxy.mapper.UserMapper;
import com.woniuxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: jackpoit
 * @date: 2021/7/24 21:43
 * @description: 用户业务逻辑层实现类
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;

	@Override
	public boolean isUserExist(String name) {
		if (StringUtil.isEmpty(name)) {
			return false;
		}
		User user = new User();
		user.setUsername(name);
		List<User> list = mapper.findByCondition(user);
		return !list.isEmpty();
	}

	@Override
	public User doLogin(User user) {
		if (user == null) {
			return null;
		}
		List<User> list = mapper.findByCondition(user);
		return list.size() == 1 ? list.get(0) : null;
	}

	@Override
	public boolean doRegister(User user) {
		if (user == null) {
			return false;
		}
		int row = mapper.add(user);
		return row > 0;
	}

	@Override
	public boolean doDelete(Integer... ids) {
		if (ids == null) {
			return false;
		}
		int row = mapper.deleteByIds(ids);
		return row > 0;
	}

	@Override
	public boolean doUpdate(User user) {
		if (user == null) {
			return false;
		}
		int row = mapper.update(user);
		return row > 0;
	}

	@Override
	public PageInfo<User> findOnePage(int currentPage,Integer id,String username,String mobile) {
		if (currentPage < 0) {
			return null;
		}
		PageHelper.startPage(currentPage, 5);
		List<User> list = mapper.findBySome(id,username,mobile);
		PageInfo<User> info = new PageInfo<>(list);
		return info;
	}

	@Override
	public User findById(int id) {
		User user = new User();
		user.setId(id);
		List<User> list = mapper.findByCondition(user);
		return list.size()==1?list.get(0):null;
	}

}

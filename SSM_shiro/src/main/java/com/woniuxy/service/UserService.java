package com.woniuxy.service;

import com.woniuxy.bean.User;

import java.util.List;

/**
 * @Author: rua
 * @Date: 2021/8/21 16:57
 * @Description:
 */
public interface UserService {

	/**
	 * 查询所有用户
	 * @return
	 */
	List<User> findAll();
}

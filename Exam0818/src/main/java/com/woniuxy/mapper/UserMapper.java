package com.woniuxy.mapper;

import com.woniuxy.bean.User;

import java.util.List;

/**
 * @Author: rua
 * @Date: 2021/8/18 12:03
 * @Description:
 */
public interface UserMapper {


	List<User> findByCondition(User user);

	int add(User user);
}

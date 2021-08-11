package com.woniuxy.service;

import com.woniuxy.dao.UserDao;
import lombok.Data;

/**
 * @Author: rua
 * @Date: 2021/8/11 12:19
 * @Description:
 */
@Data
public class UserService {
	private UserDao userDao;

	public void add(){
		System.out.println("service add");
		userDao.add();
	}


}

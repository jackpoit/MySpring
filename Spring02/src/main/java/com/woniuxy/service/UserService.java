package com.woniuxy.service;

import com.woniuxy.dao.UserDao;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: rua
 * @Date: 2021/8/11 12:19
 * @Description:
 */

@Data
@Service("userService")
public class UserService {

	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;

	public void add(){
		System.out.println("service add");
		userDao.add();
	}


}

package com.woniuxy.test;

import com.woniuxy.dao.EmpDao;
import com.woniuxy.dao.UserDao;
import com.woniuxy.dao.impl.EmpDaoImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: rua
 * @Date: 2021/8/15 22:11
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class SpringTest {

	@Autowired
	private EmpDao empDao;

	@Autowired
	private UserDao userDao;

	@Test
	public void demo() {
//		empDao.add();
// 		userDao.add();

//		empDao.delete();
//		userDao.deleteById();

//		empDao.find();
//		empDao.findAll();

		empDao.update();
		userDao.update();
	}
}

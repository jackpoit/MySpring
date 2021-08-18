package com.woniuxy.test;

import com.woniuxy.dao.EmpDao;
import com.woniuxy.dao.UserDao;
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

/**
 * AOP真实场景
 * 1.事务[管理事务的最高效方法]
 * 2.权限校验
 * 3.在执行某些关键的方法代码前后打印步骤日志
 * 4.性能上的检测[时间,空间内存消耗,负载量
 * 	集群->线程高并发->定制化->微服务]
 *
 *
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

package com.woniuxy.test;

import com.woniuxy.bean.User;
import com.woniuxy.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: rua
 * @Date: 2021/8/21 15:47
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class SpringTest {


	@Autowired
	private DataSource druid;

	@Autowired
	private UserMapper userMapper;
	@Test
	public void demo1() throws SQLException {
		//1.判断ioc是否成功
		//2.判断数据库是否连接成功
		System.out.println(druid.getConnection());
	}
	@Test
	public void demo2() throws SQLException {
		List<User> list = userMapper.selectAll();
		for (User user : list) {
			System.out.println(user);
		}
	}

}

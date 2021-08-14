package com.woniuxy.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Author: rua
 * @Date: 2021/8/14 16:00
 * @Description:
 */

/**
 * SSM框架所用的数据库连接池 主要是这三个
 *  druid c3p0 dbcp
 *  harika (springboot中的)
 *
 *
 */

public class DBTest {
	public static void main(String[] args) throws SQLException {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application3.xml");
//		DataSource c3p0 = (DataSource) applicationContext.getBean("c3p0");
//		DataSource druid = (DataSource) applicationContext.getBean("druid");
//		DataSource dbcp = (DataSource) applicationContext.getBean("dbcp");

//		System.out.println(c3p0.getConnection());
//		System.out.println(druid.getConnection());
//		System.out.println(dbcp.getConnection());

		JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);
		String sql ="delete from t_emp where id=?";
		int row = jdbcTemplate.update(sql, 54);
		System.out.println(row);

	}
}

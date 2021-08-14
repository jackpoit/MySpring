package com.woniuxy.dao.impl;

import com.woniuxy.dao.EmployeeDao;
import com.woniuxy.entity.Employee;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Author: rua
 * @Date: 2021/8/14 16:48
 * @Description: dao实现类对象 操作JDBC
 */
public class EmployeeDaoImpl implements EmployeeDao {

	private JdbcTemplate jdbcTemplate; //单例
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Employee> findAll() {
		String sql="select id,name,gender,salary  from t_emp";
		return  jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class));
	}

	@Override
	public Employee findById() {
		return null;
	}
}

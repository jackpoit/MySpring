package com.woniuxy.dao.impl;

import com.woniuxy.dao.EmployeeDao;
import com.woniuxy.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: rua
 * @Date: 2021/8/14 16:48
 * @Description: dao实现类对象 操作JDBC
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate; //单例


	//Spring jdbc查不到数据程序会崩溃,所以要try catch程序优化一下
	@Override
	public List<Employee> findAll() {
		try {
			String sql="select *  from t_emp";
			return  jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee findById(int id) {
		try {
			String sql = "select *  from t_emp where id=?";
			return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Employee.class), id);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}

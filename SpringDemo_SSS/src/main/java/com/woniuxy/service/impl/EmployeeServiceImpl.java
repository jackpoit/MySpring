package com.woniuxy.service.impl;

import com.woniuxy.dao.EmployeeDao;
import com.woniuxy.entity.Employee;
import com.woniuxy.service.EmployeeService;

import java.util.List;

/**
 * @Author: rua
 * @Date: 2021/8/14 21:36
 * @Description: 业务逻辑层实现类(真实的业务逻辑,调用DAO的API完成相关的业务逻辑)
 */

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public List<Employee> queryAllEmp() {
		return employeeDao.findAll();
	}
}

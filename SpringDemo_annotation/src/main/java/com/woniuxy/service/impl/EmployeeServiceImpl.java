package com.woniuxy.service.impl;

import com.woniuxy.dao.EmployeeDao;
import com.woniuxy.entity.Employee;
import com.woniuxy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: rua
 * @Date: 2021/8/14 21:36
 * @Description: 业务逻辑层实现类(真实的业务逻辑,调用DAO的API完成相关的业务逻辑)
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;


	@Override
	public List<Employee> queryAllEmp() {
		return employeeDao.findAll();
	}
}

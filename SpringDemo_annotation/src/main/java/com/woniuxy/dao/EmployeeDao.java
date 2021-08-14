package com.woniuxy.dao;

import com.woniuxy.entity.Employee;

import java.util.List;

/**
 * @Author: rua
 * @Date: 2021/8/14 16:47
 * @Description:
 */
public interface EmployeeDao {

	List<Employee> findAll();

	Employee findById(int id);

}

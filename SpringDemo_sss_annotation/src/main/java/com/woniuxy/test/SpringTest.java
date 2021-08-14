package com.woniuxy.test;

import com.woniuxy.dao.EmployeeDao;
import com.woniuxy.entity.Employee;
import com.woniuxy.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author: rua
 * @Date: 2021/8/14 16:58
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class SpringTest {

	@Autowired //按照类型来自动装配属性的值
	private EmployeeDao empDao;

	@Autowired
	private EmployeeService esi;

	@Test
	public void testDao(){
		List<Employee> list = esi.queryAllEmp();
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}
	@Test
	public void test2(){

		Employee emp = empDao.findById(1);
		System.out.println(emp);

	}

}

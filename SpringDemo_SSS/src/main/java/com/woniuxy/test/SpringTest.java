package com.woniuxy.test;

import com.woniuxy.dao.EmployeeDao;
import com.woniuxy.entity.Employee;
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

	@Test
	public void testDao(){
		List<Employee> list = empDao.findAll();
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}
}

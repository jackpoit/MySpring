package com.woniuxy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: rua
 * @Date: 2021/8/11 14:53
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	private Integer id;
	private String stuName;
	private String stuPhone;
	private Teacher teacher;

	public Student(Integer id, String stuName, String stuPhone) {
		this.id = id;
		this.stuName = stuName;
		this.stuPhone = stuPhone;
	}
}

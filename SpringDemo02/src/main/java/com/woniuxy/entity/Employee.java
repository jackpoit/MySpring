package com.woniuxy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: rua
 * @Date: 2021/8/14 14:02
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String gender;
	private BigDecimal salary;

	private Department dept;


	public Employee(Integer id) {
		this.id = id;
	}

	public Employee(Integer ids, String name, String gender) {
		this.id = ids;
		this.name = name;
		this.gender = gender;
	}
}

package com.woniuxy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: rua
 * @Date: 2021/8/14 14:37
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

	private Integer id; //部门编号
	private String dname; //部门名称
	private String zone; //部门所负责的地区


}

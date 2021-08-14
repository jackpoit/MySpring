package com.woniuxy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
	private String tno;
	private String name;
	private String gender;
	private Date birthday;
	private String title;
	private BigDecimal salary;
	private Integer managerId;
	private Integer deptId;
	private String image;


}

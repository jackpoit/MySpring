package com.woniuxy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: rua
 * @Date: 2021/8/18 14:13
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecondType implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String secondTypeName;
}

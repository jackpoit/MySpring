package com.woniuxy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: rua
 * @Date: 2021/8/19 15:59
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private Integer id;
	private String userNo;
	private String userPass;
	private String codePass;
	private Integer count;
	private String saltValue;
	private String userPhone;
}

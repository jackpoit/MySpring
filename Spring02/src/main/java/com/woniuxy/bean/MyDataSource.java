package com.woniuxy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: rua
 * @Date: 2021/8/11 15:55
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyDataSource {
	private String url;
	private String user;
	private String password;
	private String driverClassName;

	private int initPoolSize;
	private int maxPoolSize;

}

package com.woniuxy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: rua
 * @Date: 2021/8/12 19:23
 * @Description:
 */
@Data
@AllArgsConstructor
public class User {
	private Long id;
	private String uname;
	private String password;

	public User() {
		System.out.println("User创建了"); //框架创建对象默认调用无参构造
	}
	public void init(){
		System.out.println("init...");
	}
	public void destroy(){
		System.out.println("destroy...");
	}

}

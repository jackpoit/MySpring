package com.woniuxy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: rua
 * @Date: 2021/8/12 19:23
 * @Description:
 */

/**
 * 明确说:实体类不可能交给Spring来管理
 * 现在交给Spring主要用来理解 IOC和DI
 */
@Data
@AllArgsConstructor
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
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

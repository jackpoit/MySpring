package com.woniuxy.controller;

import com.woniuxy.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

/**
 * @Author: rua
 * @Date: 2021/8/12 10:50
 * @Description:
 */
@Controller("userController")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserController {
	@Value("1")
	private Integer id;


	@Autowired
	@Qualifier("userService")
	private UserService userService;

	public void add(){
		System.out.println("controller add");
		userService.add();
		userService.getUserDao().add();

	}

	public UserController(Integer id) {
		this.id = id;
	}
}

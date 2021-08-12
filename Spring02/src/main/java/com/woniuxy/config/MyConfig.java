package com.woniuxy.config;

import com.woniuxy.controller.UserController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: rua
 * @Date: 2021/8/12 10:56
 * @Description:
 */
@Configuration
public class MyConfig {

	@Bean("userController")
	public UserController getUserController() {
		return new UserController(2);

	}
}

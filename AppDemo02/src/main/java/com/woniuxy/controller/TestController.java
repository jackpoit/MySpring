package com.woniuxy.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;

/**
 * @Author: rua
 * @Date: 2021/8/12 15:43
 * @Description:
 */
@Controller
@Data
public class TestController {

	@Autowired
	private DataSource dataSource;
}

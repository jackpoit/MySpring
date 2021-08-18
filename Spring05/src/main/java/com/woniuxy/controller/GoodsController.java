package com.woniuxy.controller;

import com.woniuxy.exception.GoodsPriceException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: rua
 * @Date: 2021/8/16 17:21
 * @Description:
 */
@Controller
public class GoodsController {

	@RequestMapping("getPrice")
	public String getPrice(double price){
		if (price<0||price>10000){
			throw new GoodsPriceException("0-10000");
		}
		return "index";
	}


	@ExceptionHandler(GoodsPriceException.class)
	public String goodsPriceException(GoodsPriceException e){
		System.err.println("商品异常"+e.getMessage());

		return "/error/404";
	}

}

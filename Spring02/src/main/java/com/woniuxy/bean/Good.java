package com.woniuxy.bean;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: rua
 * @Date: 2021/8/11 14:25
 * @Description:
 */
@Data
public class Good implements Serializable {
	private Integer id;
	private String goodsName;
	private BigDecimal goodsPrice;
	private GoodType goodType;


}

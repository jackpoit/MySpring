package com.woniuxy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: rua
 * @Date: 2021/8/18 14:09
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Good implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String goodsName;
	private Integer goodsCount;
	private BigDecimal goodsPrice;
	private String goodsImg;
	private Integer goodsFirstId;
	private Integer goodsSecondId;
	private Integer goodsStatus;
	private FirstType firstType;
	private SecondType secondType;

}

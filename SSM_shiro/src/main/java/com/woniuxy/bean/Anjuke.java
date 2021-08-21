package com.woniuxy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @Author: rua
 * @Date: 2021/7/27 18:59
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "anjuke_rent")
public class Anjuke {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "zone")
	private String zone;
	private String trainLine;
	private BigDecimal rentMoney;
	private String room;
	private String rentType;
	private String layout;
	private String direction;
}

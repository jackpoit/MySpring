package com.woniuxy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: rua
 * @Date: 2021/8/14 23:24
 * @Description:
 */
@Component  //优先级没xml的高
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

	@Value("1000")
	private Integer id;

	@Value("红旗")
	private String brand;
}

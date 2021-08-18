package com.woniuxy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * @Author: rua
 * @Date: 2021/8/14 15:15
 * @Description:
 */

/**
 * 验证高级类型的DI注入[通过set方法注入]
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Bean {
	private String[] arr;
	private ArrayList<Integer> lists;
	private Set<String> sets;
	private HashMap<Integer,String> hashMap;
}

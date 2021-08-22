package com.woniuxy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: rua
 * @Date: 2021/8/22 18:28
 * @Description: 与业务相关的实体类
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActiceUser implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer uid; //用户id
	private String username;
	private List<Permission> menus;
	private List<Permission> permission;

}

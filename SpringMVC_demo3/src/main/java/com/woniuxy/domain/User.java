package com.woniuxy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: jackpoit
 * @Date: 2021/08/17/23:42
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id; //编号
	private String uname;//昵称
	private String realname;//真实姓名
	private String pwd;//真实姓名
	private Integer gender;//0:男 1:女
	private Integer status;//权限码

	@DateTimeFormat(pattern = "yyyy-MM-dd") //在封装birthday是会自动使用自带的转换器来转换类型
	private Date birthday; //生日

	public User(Integer id, String uname, String realname) {
		this.id = id;
		this.uname = uname;
		this.realname = realname;
	}
}

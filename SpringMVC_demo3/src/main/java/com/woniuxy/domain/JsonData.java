package com.woniuxy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: jackpoit
 * @Date: 2021/08/18/1:56
 * @Description: 通用的返回json对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonData implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer status;//状态码
	private String msg; //对于此状态的描述
	private Object content;//响应正文

	public JsonData(Integer status, String msg) {
		this.status = status;
		this.msg = msg;
	}
}

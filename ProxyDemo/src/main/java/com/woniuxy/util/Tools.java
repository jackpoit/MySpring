package com.woniuxy.util;

/**
 * @Author: rua
 * @Date: 2021/8/15 18:29
 * @Description:
 */

/**
 * 通知类型
 */
public class Tools {

	public static void writeLog() {
		System.out.println("#####日志管理输出#####");
	}

	public static int preCheck() {
		int num=32;
		int code=num^123;
		System.out.println("#####权限校验"+code+"#####");
		return code;
	}
}

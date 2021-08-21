package com.woniuxy.test;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @Author: rua
 * @Date: 2021/8/21 10:15
 * @Description:
 */
public class MD5Test {
	public static void main(String[] args) {
		//1.MD5加密算法使用方式1
		String source="123"; //原码
		Object salt=null; //盐值
		int hashIterations=1;//加密次数
		Md5Hash md5Hash = new Md5Hash(source, salt, hashIterations);
		System.out.println(md5Hash);

		//2.MD5加密算法使用方式2
		new SimpleHash("MD5",source,salt,hashIterations);

	}
}

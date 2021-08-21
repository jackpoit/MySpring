package com.woniuxy.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @Author: rua
 * @Date: 2021/8/19 14:47
 * @Description:
 */
public class PassUtil {


	/**
	 * 获取加密后的密文
	 * @param algorithmName 加密类型
	 * @param source 需要加密的原文
	 * @param saltValue 盐值
	 * @param hashIterations 加密迭代次数
	 * @return 加密后的密文
	 */
	public static String getHashPass(String algorithmName, Object source, Object saltValue, int hashIterations) {
		Object salt=null;
		if (saltValue!=null)
			salt=ByteSource.Util.bytes(saltValue);

		SimpleHash simpleHash = new SimpleHash(algorithmName, source, salt, hashIterations);
		return simpleHash.toString();
	}
}

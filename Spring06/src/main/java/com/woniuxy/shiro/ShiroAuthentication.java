package com.woniuxy.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;

/**
 * @Author: rua
 * 认证: 将用户校验[前端form]的账号面与info.ini配置文件中的账号密码进行比对
 */
public class ShiroAuthentication {
	public static void main(String[] args) {
		//1.创建shiro安全管理工厂
		IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:my.ini");
		//2.从工厂创建出securityManager安全管理对象
		SecurityManager securityManager = factory.getInstance();
		//3.将安全管理对象与shiro环境绑定
		SecurityUtils.setSecurityManager(securityManager);
		//4.创建待校验的subject

	}
}

package com.woniuxy.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * @Author: rua
 * @Date: 2021/8/19 10:13
 */
public class ShiroTest {

	@Test
	public void test01() {
		//1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:my.ini");
		//2、得到SecurityManager实例
		SecurityManager securityManager = factory.getInstance();
		//3. 交给安全管理器的工具类进行管理:绑定给SecurityUtils
		SecurityUtils.setSecurityManager(securityManager);
		//4.得到subject对象(shiro与应用程序交互的一个对象)
		Subject subject = SecurityUtils.getSubject();
		//5.模拟用户输入的账号和密码,并将其存入token对象中
		UsernamePasswordToken token = new UsernamePasswordToken("admin", "123456");
		//6.根据用户名输入的用户名和密码进行登录
		try {
			subject.login(token);
			System.out.println("身份认证成功");
			//判断登入的用户拥有何种权限
			if (subject.hasRole("manager"))//登入的账号 是什么角色
				System.out.println("manager角色");

			if (subject.hasRole("user"))
				System.out.println("user角色");

			if (subject.isPermitted("query"))
				System.out.println("拥有查询权限");
			if (subject.isPermitted("add"))
				System.out.println("拥有添加权限");
			if (subject.isPermitted("delete"))
				System.out.println("拥有删除权限");
			if (subject.isPermitted("update"))
				System.out.println("拥有更新权限");


		} catch (UnknownAccountException e) {
			System.err.println("用户名不存在");
		} catch (IncorrectCredentialsException e) {
			System.err.println("密码错误");
		} catch (AuthenticationException e) {
			System.err.println("其他认证异常");
		}

		//是否认证通过
		boolean flag = subject.isAuthenticated();

	}
}

package com.woniuxy.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @Author: rua
 *通过MD5算法来认证校验
 *
 *
 */
public class MyRealmMD5 extends AuthorizingRealm {

	//2.授权规则
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	//1.认证规则
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		Object principal = token.getPrincipal();
		if (!"admin".equals(principal)) { //模拟数据库只有一个admin账号
			return null; //自动被unknownAccountException 捕获 [账号不存在]
		}
		Object credentials = "123";


		//1.构建一个AuthenticationInfo认证信息对象
		/**
		 *将真实凭证credentials 与token中的password进行比较 若相同就返回info
		 * 不相同,抛出 IncorrectCredentialsException [密码错误]
		 */
		return new SimpleAuthenticationInfo(principal, credentials, this.getName());
	}
}

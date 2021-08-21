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
 * 自定义realm [域:校验规则]
 * 1.类 extends AuthorizingRealm [用于授权的realm]
 * 2.重写doGetAuthenticationInfo doGetAuthorizationInfo
 *
 */
public class MyRealm extends AuthorizingRealm {

	//2.授权规则
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	//1.认证规则
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//1.principal 身份信息[账号,用户对象]
		Object principal = token.getPrincipal();
		//2.真实开发使用这个身份从数据库查询该账号是否存在
		if (!"admin".equals(principal)) { //模拟数据库只有一个admin账号
			return null; //自动被unknownAccountException 捕获 [账号不存在]
		}
		//3.credential 真实的数据库凭证[账号对应的数据库密码]
		Object credentials = "123";


		//1.构建一个AuthenticationInfo认证信息对象
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, this.getName());
		/**
		 *将真实凭证credentials 与token中的password进行比较 若相同就返回info
		 * 不相同,抛出 IncorrectCredentialsException [密码错误]
		 */
		return info;
	}
}

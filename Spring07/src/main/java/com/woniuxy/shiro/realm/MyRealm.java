package com.woniuxy.shiro.realm;

import com.woniuxy.util.PassUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.UUID;

/**
 * @Author: rua
 * @Date: 2021/8/19 12:12
 * @Description:
 */
public class MyRealm extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		return null;
	}

	//重写此方法进行 认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

		//1.得到用户输入的信息(账号和密码)
		UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
		//2.根据账号从数据库查询出整个用户信息
		//根据用户输入账号从数据库查询出来的用户信息(一般是用户名)
		Object principal = userToken.getUsername();
		if (!"admin".equals(principal) && !"charles".equals(principal)) {
			throw new UnknownAccountException("用户认证失败");
		}
		//查询出的密码(数据库查询的密码)
		Object hashedCredentials = "f4345379d81228277cecaca34cc7904ca83bb940";
		if (principal.equals("admin")) {
			hashedCredentials = "f4345379d81228277cecaca34cc7904ca83bb940";
		} else {
			hashedCredentials = "a69013fbb865c7822f0de93456324288b2aecfe4";
		}
		//盐值
		ByteSource credentialsSalt = ByteSource.Util.bytes(principal); //输入的用户名
		//
		String realmName = getName();

		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, hashedCredentials, credentialsSalt, realmName);
		return info;
	}

	public String getPass() {
		//		模拟出数据库加密的密文出来
		//类型
		String algorithmName = "SHA-1";
		//原文
		Object source = "123456";
		//盐值
		Object salt = ByteSource.Util.bytes("charles");
		//迭代次数
		int hashIterations = 1023;
		SimpleHash simpleHash = new SimpleHash(algorithmName, source, salt, hashIterations);
		return simpleHash.toString();
	}

	public static void main(String[] args) {
//		System.out.println(new MyRealm().getPass());
		// admin:f4345379d81228277cecaca34cc7904ca83bb940
		//charles:a69013fbb865c7822f0de93456324288b2aecfe4

		for (int i = 0; i < 4; i++) {

//			String uuid= UUID.randomUUID().toString().replace("-","");
			String md5 = PassUtil.getHashPass("MD5", "123456", "7cd0124b1a2548c28d518f72bcb78154", 1023);
//			System.out.println(uuid);
			System.out.println(md5);
		}

	}
}

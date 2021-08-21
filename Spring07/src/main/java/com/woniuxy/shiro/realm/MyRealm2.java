package com.woniuxy.shiro.realm;

import com.woniuxy.bean.User;
import com.woniuxy.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: rua
 * @Date: 2021/8/19 16:06
 * @Description:
 */
public class MyRealm2 extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		Object userName = principals.getPrimaryPrincipal();
		Set<String> roles = new HashSet<>();
		if (userName.equals("marry")){
			roles.add("manager");
		}
		if (userName.equals("jack")){
			roles.add("manager");
		}
		roles.add("user");
		return new SimpleAuthorizationInfo(roles);
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken= (UsernamePasswordToken) token;

		User user = userService.doLogin(usernamePasswordToken.getUsername());
		if (user==null)
			throw new UnknownAccountException();
		Object principal = usernamePasswordToken.getUsername();
		Object hashedCredentials = user.getCodePass();
		ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSaltValue());
		String realmName = getName();

		return new SimpleAuthenticationInfo(principal, hashedCredentials, credentialsSalt, realmName);

	}
}

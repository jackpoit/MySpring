package com.woniuxy.shiro.realm;

import com.woniuxy.bean.ActiceUser;
import com.woniuxy.bean.Permission;
import com.woniuxy.bean.User;
import com.woniuxy.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @Author: rua
 * @Date: 2021/8/22 21:16
 * @Description:
 */
public class MyRealm extends AuthorizingRealm {
	@Autowired
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		ActiceUser acticeUser = (ActiceUser) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		for (Permission permission : acticeUser.getPermission()) {
			simpleAuthorizationInfo.addStringPermission(permission.getPercode());
		}

		return simpleAuthorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken= (UsernamePasswordToken) authenticationToken;

		User user = userService.doLogin(usernamePasswordToken.getUsername());
		if (user==null)
			return null;
		Object principal = usernamePasswordToken.getUsername();
		ActiceUser acticeUser = new ActiceUser();
		acticeUser.setUid(user.getUid());
		acticeUser.setPermission(userService.getUserPermissions(user.getUid()));
		acticeUser.setUsername(user.getUsername());
		Object hashedCredentials = user.getPassword();
		ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt());
		String realmName = getName();

		return new SimpleAuthenticationInfo(acticeUser, hashedCredentials, credentialsSalt, realmName);


	}
}

/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.shiro.realm;

import com.zhu.shiro.dao.UserroleDao;
import com.zhu.shiro.entity.User;
import com.zhu.shiro.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;

import java.nio.Buffer;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author 朱桂林 create 2021/2/3 11:14
 */
public class MySpringBootRealm extends AuthorizingRealm {
	@Value("${shiro.salt}")
	private String salt;
	@Autowired
	private UserService userService;

	@Autowired
	private UserroleDao userroleDao;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
		User user = userService.findByUsername(primaryPrincipal);
		Set<String> roles = userroleDao.findByUserid(user.getId()).stream().collect(Collectors.toSet());
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo(roles);
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		String principal = (String) authenticationToken.getPrincipal();

		User user = userService.findByUsername(principal);
		if (user != null) {
			SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),ByteSource.Util.bytes(user.getSalt()),getName());
			return simpleAuthenticationInfo;
		}
		return null;
	}
}

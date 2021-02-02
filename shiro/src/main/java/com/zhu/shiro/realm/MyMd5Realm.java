/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * @author 朱桂林 create 2021/2/2 16:52
 */
public class MyMd5Realm extends AuthorizingRealm {
	/**
	 * 授权
	 * @param principalCollection
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		return null;
	}

	/**
	 * 认证
	 * @param authenticationToken
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		String principal = (String) authenticationToken.getPrincipal();
		if ("xiaozhu".equals(principal)) {
			//654112e1c6bcfae709263e981b4ffe9c是使用shiro的md5加密出来的
			//Md5Hash md5Hash = new Md5Hash("123","salt",100);
			//System.out.println(md5Hash.toHex());
			SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(principal,"654112e1c6bcfae709263e981b4ffe9c", ByteSource.Util.bytes("salt"),getName());
			return simpleAuthenticationInfo;
		}
		return null;
	}
}

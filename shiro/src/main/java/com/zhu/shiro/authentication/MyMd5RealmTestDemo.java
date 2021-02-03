/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.shiro.authentication;

import com.zhu.shiro.realm.MyMd5Realm;
import com.zhu.shiro.realm.MyRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

import java.util.Arrays;

/**
 * @author 朱桂林 create 2021/2/2 16:53
 */
public class MyMd5RealmTestDemo {
	/*public static void main(String[] args) {
		MyMd5Realm singleRealm = new MyMd5Realm();
		HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
		credentialsMatcher.setHashAlgorithmName("md5");//使用md5做加密需要设置加密类型
		credentialsMatcher.setHashIterations(100);//如果做散列的话，需要告诉匹配器散列次数
		singleRealm.setCredentialsMatcher(credentialsMatcher);
		SecurityManager securityManager = new DefaultSecurityManager(singleRealm);

		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("xiaozhu", "123");
		subject.login(token);
		System.out.println(subject.isAuthenticated());


		if(subject.isAuthenticated()){
			//基于角色
			System.out.println(subject.hasRole("admin"));//是否拥有某一个角色
			System.out.println(subject.hasAllRoles(Arrays.asList("admin", "user")));//是否拥有多个角色
			System.out.println(Arrays.toString(subject.hasRoles(Arrays.asList("admin", "user"))));//是否拥有其中一个角色

			System.out.println("====================");

			//基于资源
			System.out.println(subject.isPermitted("user:*:01"));
			System.out.println(subject.isPermitted("user:*:02"));
			System.out.println(subject.isPermitted("user:*:*"));
		}
	}*/
}

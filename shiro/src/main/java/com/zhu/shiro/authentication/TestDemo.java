/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.shiro.authentication;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

/**
 * @author 朱桂林 create 2021/2/2 10:46
 */
public class TestDemo {
	public static void main(String[] args) {
		//创建安全管理器
		SecurityManager securityManager =new DefaultSecurityManager(new IniRealm("classpath:shiro.ini"));

		//使用utils工具类，告诉工具类我们要使用的安全管理器
		SecurityUtils.setSecurityManager(securityManager);

		//用户
		Subject subject = SecurityUtils.getSubject();

		//创建token
		UsernamePasswordToken xiaozhu = new UsernamePasswordToken("xiaozhu", "123");

		try {
			System.out.println(subject.isAuthenticated());
			subject.login(xiaozhu);//登录
			System.out.println(subject.isAuthenticated());
		} catch (UnknownAccountException e) {
			e.printStackTrace();
			System.out.println("用户名错误");
		} catch (IncorrectCredentialsException e) {
			e.printStackTrace();
			System.out.println("密码错误");
		} catch (AuthenticationException e){
			e.printStackTrace();
		}
	}
}

package com.zhu.shiro.authentication;

import com.zhu.shiro.realm.MyRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * @author 朱桂林 create 2021/2/2 15:39
 */
public class MyRealmTestDemo {
	/*public static void main(String[] args) {
		SecurityManager securityManager = new DefaultSecurityManager(new MyRealm());

		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("xiaozhu", "123");
		subject.login(token);
		System.out.println(subject.isAuthenticated());
	}*/
}

package com.zhu.shiro.config;

import com.zhu.shiro.cache.RedisCacheManager;
import com.zhu.shiro.realm.MyRealm;
import com.zhu.shiro.realm.MySpringBootRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * 整合shiro相关的配置类
 * @author 朱桂林 create 2021/2/3 11:08
 */
@Configuration
public class ShiroConfig {
	//filter
	@Bean
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
		HashMap<String, String> filterChainDefinitionMap = new HashMap<>();
		//authc表示需要认证和授权
		//anon 不用认证和授权，代表公共资源
		filterChainDefinitionMap.put("/index.jsp","authc");
		filterChainDefinitionMap.put("/regist.jsp","anon");
		filterChainDefinitionMap.put("/**","authc");
		filterChainDefinitionMap.put("/user/*","anon");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

		//默认就是/login.jsp
		shiroFilterFactoryBean.setLoginUrl("/login.jsp");
		return shiroFilterFactoryBean;
	}

	//安全管理器
	@Bean
	public DefaultWebSecurityManager getDefaultWebSecurityManager(MySpringBootRealm realm){
		DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
		defaultWebSecurityManager.setRealm(realm);
		return defaultWebSecurityManager;
	}

	//realm
	@Bean
	public MySpringBootRealm realm(){
		MySpringBootRealm mySpringBootRealm = new MySpringBootRealm();
		HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
		credentialsMatcher.setHashIterations(100);
		credentialsMatcher.setHashAlgorithmName("md5");
		mySpringBootRealm.setCredentialsMatcher(credentialsMatcher);

		//整合ehcache缓存
		//mySpringBootRealm.setCacheManager(new EhCacheManager());//使用ehcache的manager
		mySpringBootRealm.setCacheManager(new RedisCacheManager());//使用redisCacheManager
		mySpringBootRealm.setCachingEnabled(true);//开启全局缓存
		mySpringBootRealm.setAuthenticationCachingEnabled(true);//开启认证缓存
		mySpringBootRealm.setAuthenticationCacheName("authenticationCache");
		mySpringBootRealm.setAuthorizationCachingEnabled(true);//开启授权缓存
		mySpringBootRealm.setAuthorizationCacheName("authorizationCache");
		return mySpringBootRealm;
	}
}

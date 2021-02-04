package com.zhu.shiro.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.UUID;

/**
 * @author 朱桂林 create 2021/2/3 15:52
 */
public class Utils {
	private static ApplicationContext context;

	public static String getSalt(){
		return UUID.randomUUID().toString().substring(4,8);
	}

	public static void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context=applicationContext;
	}

	public static <T> T getBean(Class<T> clazz){
		T bean = context.getBean(clazz);
		return bean;
	}

	public static Object getBean(String name){
		Object bean = context.getBean(name);
		return bean;
	}
}

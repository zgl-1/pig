/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.springredis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 朱桂林 create 2021/1/11 14:32
 */
public class Tets {
	@Autowired
	private static RedisTemplate<Object,Object> redisTemplate;

	public static void main(String[] args) {
		Map<String,String> map = new HashMap();
		map.put("name","xiaozhu");
		map.put("age","22");
		map.put("phone","3232323");
		redisTemplate.opsForHash().putAll("hashmap", map);
		System.out.println(redisTemplate.opsForHash().entries("hashmap"));
	}
}

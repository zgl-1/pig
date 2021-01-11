/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.springredis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 朱桂林 create 2021/1/11 14:40
 */
@RestController
public class TestController {
	@Autowired
	private RedisTemplate redisTemplate;

	@GetMapping("/test")
	public Object getTest(){
		Map<String,String> map = new HashMap();
		map.put("name","xiaozhu");
		map.put("age","22");
		map.put("phone","3232323");
		redisTemplate.opsForHash().putAll("hashmap", map);
		System.out.println(redisTemplate.opsForHash().entries("hashmap"));
		return redisTemplate.opsForHash().entries("hashmap");
	}
}

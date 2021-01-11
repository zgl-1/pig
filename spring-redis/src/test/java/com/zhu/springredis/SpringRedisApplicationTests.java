package com.zhu.springredis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringRedisApplicationTests {

	@Autowired
	private RedisTemplate<Object,Object> redisTemplate;

	@Test
	void contextLoads() {
		Map<String,String> map = new HashMap();
		map.put("name","xiaozhu");
		map.put("age","22");
		map.put("phone","3232323");
		redisTemplate.opsForHash().putAll("hashmap", map);
		System.out.println(redisTemplate.opsForHash().entries("hashmap"));
	}

}

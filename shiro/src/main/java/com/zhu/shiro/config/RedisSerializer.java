package com.zhu.shiro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisSerializer {
	/*@Bean
	public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
		RedisTemplate<Object,Object> redisTemplate=new RedisTemplate<Object,Object>();
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		redisTemplate.setConnectionFactory(redisConnectionFactory);

		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
		redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
		redisTemplate.setStringSerializer(new StringRedisSerializer());
		return redisTemplate;
	}*/
}
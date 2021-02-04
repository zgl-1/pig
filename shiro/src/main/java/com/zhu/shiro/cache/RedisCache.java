package com.zhu.shiro.cache;


import com.zhu.shiro.util.Utils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Collection;
import java.util.Set;

/**
 * 自定义redis缓存
 * @author 朱桂林 create 2021/2/4 9:50
 */
public class RedisCache<K, V> implements Cache<K, V> {
	private String cacheName;
	public RedisCache() {
	}

	public RedisCache(String cacheName) {
		this.cacheName = cacheName;
	}

	@Override
	public V get(K k) throws CacheException {
		System.out.println("get-K:"+k);
		RedisTemplate redisTemplate = (RedisTemplate) Utils.getBean("redisTemplate");
		Object o = redisTemplate.opsForHash().get(cacheName,k.toString());
		V value = (V) o;
		return value;
	}

	@Override
	public V put(K k, V v) throws CacheException {
		System.out.println("put-K:"+k);
		System.out.println("put-v:"+v);
		RedisTemplate redisTemplate = (RedisTemplate) Utils.getBean("redisTemplate");
		redisTemplate.opsForHash().put(cacheName,k.toString(),v);

		return null;
	}

	@Override
	public V remove(K k) throws CacheException {
		RedisTemplate redisTemplate = (RedisTemplate) Utils.getBean("redisTemplate");
		return (V) redisTemplate.opsForHash().delete(cacheName,k.toString());
	}

	@Override
	public void clear() throws CacheException {
		RedisTemplate redisTemplate = (RedisTemplate) Utils.getBean("redisTemplate");
		redisTemplate.opsForHash().delete(cacheName);
	}

	@Override
	public int size() {
		RedisTemplate redisTemplate = (RedisTemplate) Utils.getBean("redisTemplate");
		return redisTemplate.opsForHash().size(cacheName).intValue();
	}

	@Override
	public Set<K> keys() {
		RedisTemplate redisTemplate = (RedisTemplate) Utils.getBean("redisTemplate");
		redisTemplate.opsForHash().keys(cacheName);
		return null;
	}

	@Override
	public Collection<V> values() {
		RedisTemplate redisTemplate = (RedisTemplate) Utils.getBean("redisTemplate");
		return redisTemplate.opsForHash().values(cacheName);
	}
}

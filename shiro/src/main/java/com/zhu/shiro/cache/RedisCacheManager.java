package com.zhu.shiro.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

/**
 * @author 朱桂林 create 2021/2/4 9:33
 */
public class RedisCacheManager implements CacheManager {
	/**
	 * @param s 认证或者授权缓存的名称
	 * @param <K>
	 * @param <V>
	 * @return
	 * @throws CacheException
	 */
	@Override
	public <K, V> Cache<K, V> getCache(String s) throws CacheException {
		RedisCache<K, V> kvRedisCache = new RedisCache<K, V>(s);
		return kvRedisCache;
	}
}

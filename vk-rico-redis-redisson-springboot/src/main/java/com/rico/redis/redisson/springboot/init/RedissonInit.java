package com.rico.redis.redisson.springboot.init;

import java.util.HashMap;
import java.util.Map;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.redisson.spring.cache.CacheConfig;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rico.redis.redisson.springboot.config.RedissonConfig;

@Configuration
@EnableCaching
public class RedissonInit {

	@Autowired
	private RedissonConfig redissonConfig;

	@Bean(name = "redissonClient", destroyMethod = "shutdown")
	public RedissonClient buildRedissonClient() {
		Config config = new Config();
		SingleServerConfig singleServer = config.useSingleServer();
		singleServer.setAddress(redissonConfig.getAddress());
		singleServer.setRetryAttempts(3); // 命令失败时，重试次数，默认是3次
		RedissonClient redissonClient = Redisson.create(config);
		return redissonClient;
	}

//	@Bean(name = "stringRedisTemplate")
//	public StringRedisTemplate buildStringRedisTemplate(RedisConnectionFactory connectionFactory) {
//		StringRedisTemplate stringRedisTemplate = new StringRedisTemplate(connectionFactory);
//		return stringRedisTemplate;
//	}
//
//	@Bean(name = "redisTemplate")
//	public RedisTemplate<String, String> buildRedisTemplate(RedisConnectionFactory connectionFactory) {
//		RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<Object, Object>();
//		redisTemplate.setConnectionFactory(connectionFactory);
//		return null;
//	}

	@Bean(name = "cacheManager")
	public RedissonSpringCacheManager buildCacheManager(@Qualifier("redissonClient") RedissonClient redissonClient) {
//		RedissonCache c = new RedissonCache(map, allowNullValues)
		Map<String, CacheConfig> config = new HashMap<String, CacheConfig>();
//		config.put("testMap", new CacheConfig(24*60*1000, 12*60*1000));
		config.put("testMap", new CacheConfig());
		
		RedissonSpringCacheManager cacheManager = new RedissonSpringCacheManager(redissonClient,config);
		
//		CacheResolver r = null;
		return cacheManager;
	}
}

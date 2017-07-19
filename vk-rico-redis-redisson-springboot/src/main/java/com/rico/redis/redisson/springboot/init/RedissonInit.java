package com.rico.redis.redisson.springboot.init;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rico.redis.redisson.springboot.config.RedissonConfig;

@Configuration
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
}

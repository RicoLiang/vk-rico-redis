package com.rico.redis.redisson.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("redisson.properties")
@Component("redissonConfig")
public class RedissonConfig {
	/**
	 * Redis服务器地址
	 */
	@Value("${redis.host}")
	private String host;

	/**
	 * Redis服务器连接端口
	 */
	@Value("${redis.port}")
	private int port;

	public String getHost() {
		return host;
	}

	public int getPort() {
		return port;
	}

	public String getAddress() {
		StringBuffer address = new StringBuffer("redis://");
		address.append(this.getHost()).append(":").append(this.getPort());
		return address.toString();
	}
}

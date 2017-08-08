package vk.rico.redis.springdataredis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:redis.properties")
@Component("redisConfig")
public class RedisConfig {

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

	/**
	 * Redis最大连接数
	 */
	@Value("${redis.maxTotal}")
	private int maxTotal;

	/**
	 * Redis最大空闲连接数
	 */
	@Value("${redis.maxIdle}")
	private int maxIdle;

	/**
	 * Redis最小空闲连接数
	 */
	@Value("${redis.minIdle}")
	private int minIdle;

	/**
	 * 当客户端获取一个Redis连接时，最大的等待时间（毫秒），如果超时，则直接抛出JedisConnectionException
	 */
	@Value("${redis.maxWaitMillis}")
	private long maxWaitMillis;

	/**
	 * 当客户端获取一个Redis连接时，是否提前进行validate操作；如果为true，则得到的Redis连接均是可用的
	 */
	@Value("${redis.testOnBorrow}")
	private boolean testOnBorrow;

	public String getHost() {
		return host;
	}

	public int getPort() {
		return port;
	}

	public int getMaxTotal() {
		return maxTotal;
	}

	public int getMaxIdle() {
		return maxIdle;
	}

	public int getMinIdle() {
		return minIdle;
	}

	public long getMaxWaitMillis() {
		return maxWaitMillis;
	}

	public boolean isTestOnBorrow() {
		return testOnBorrow;
	}
}

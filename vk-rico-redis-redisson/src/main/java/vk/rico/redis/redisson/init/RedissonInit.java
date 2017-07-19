package vk.rico.redis.redisson.init;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;

public class RedissonInit {
	private RedissonInit() {
	}

	private static class RedissonInitHolder {
		private static RedissonInit instance = new RedissonInit();
	}

	public static RedissonInit getInstance() {
		return RedissonInitHolder.instance;
	}

	public RedissonClient buildRedissonClient() {
		Config config = new Config();
		SingleServerConfig singleServer = config.useSingleServer();
		singleServer.setAddress("redis://192.168.1.20:6379");
		singleServer.setDatabase(0);
		RedissonClient redissonClient = Redisson.create(config);
		return redissonClient;
	}
}

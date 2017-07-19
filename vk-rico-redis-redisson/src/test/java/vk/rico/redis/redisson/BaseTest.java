package vk.rico.redis.redisson;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.redisson.api.RedissonClient;

import vk.rico.redis.redisson.init.RedissonInit;

public class BaseTest {

	protected static RedissonClient redissonClient;

	@BeforeClass
	public static void before() {
		redissonClient = RedissonInit.getInstance().buildRedissonClient();
	}

	@AfterClass
	public static void after() {
		if (null == redissonClient) {
			redissonClient.shutdown();
		}
	}
}

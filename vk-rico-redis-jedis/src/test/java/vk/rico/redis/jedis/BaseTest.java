package vk.rico.redis.jedis;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import redis.clients.jedis.Jedis;

public class BaseTest {

	protected static Jedis jedis;

	@BeforeClass
	public static void before() {
		jedis = new Jedis("192.168.1.20", 6379);
	}

	@AfterClass
	public static void after() {
		if (null == jedis) {
			jedis.close();
		}
	}
}

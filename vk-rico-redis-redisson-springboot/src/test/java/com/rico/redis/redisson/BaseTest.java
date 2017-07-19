package com.rico.redis.redisson;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseTest {

	@Autowired
	protected RedissonClient redissonClient;

	@BeforeClass
	public static void before() {
	}

	@AfterClass
	public static void after() {
	}
}

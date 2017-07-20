package com.rico.redis.redisson.springboot;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseTest {

	@Autowired
	protected RedissonClient redissonClient;

	protected Logger logger = LoggerFactory.getLogger(BaseTest.class);

	@BeforeClass
	public static void before() {
	}

	@AfterClass
	public static void after() {
	}
}

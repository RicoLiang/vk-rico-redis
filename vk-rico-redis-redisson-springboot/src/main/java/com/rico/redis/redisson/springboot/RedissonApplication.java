package com.rico.redis.redisson.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.rico.redis.redisson")
public class RedissonApplication implements CommandLineRunner {

	public static void main(String[] args) {

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("vk-rico-redis-redisson服务已经启动");
	}
}

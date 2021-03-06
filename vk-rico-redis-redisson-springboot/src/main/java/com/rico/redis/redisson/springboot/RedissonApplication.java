package com.rico.redis.redisson.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.rico.redis.redisson.springboot")
public class RedissonApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RedissonApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("vk-rico-redis-redisson服务已经启动");
	}
}

package com.rico.redis.redisson.springboot;

import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RKeys;
import org.redisson.api.RMap;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rico.redis.redisson.springboot.RedissonApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RedissonApplication.class)
public class RedissonTest extends BaseTest {

	@Test
	public void testRMap() {
		RKeys keys = redissonClient.getKeys();
		Iterable<String> keys2 = keys.getKeys();
		keys2.forEach(keyItem -> {
			System.out.println("=================================");
			RMap<Object, Object> map = redissonClient.getMap(keyItem);
			Set<Entry<Object, Object>> readAllEntrySet = map.readAllEntrySet();
			readAllEntrySet.forEach(entry -> {
				System.out.println(entry.getKey() + "\t" + entry.getValue());
			});
		});
	}
}

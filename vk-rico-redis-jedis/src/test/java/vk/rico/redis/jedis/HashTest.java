package vk.rico.redis.jedis;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.common.collect.Maps;

public class HashTest extends BaseTest {

	@Test
	public void testHash1() {
		jedis.hset("orders", "order:orderno:CO201707102138001:platform", "ALI");

		Map<String, String> hashs = Maps.newHashMapWithExpectedSize(8);
		hashs.put("order:orderno:CO201707102138001:consignee", "琴弦子");
		hashs.put("order:orderno:CO201707102138001:consigneeAddress", "深圳市龙岗区");
		hashs.put("order:orderno:CO201707102138001:orderAmount", "32.2");
		// jedis.hmset("orders", hashs);

		jedis.hmset("orders", hashs);
		jedis.hincrByFloat("orders", "order:orderno:CO201707102138001:orderAmount", 1.1);
	}

	@Test
	public void testHash11() {
		String[] fields = { "order:orderno:CO201707102138001:consignee",
				"order:orderno:CO201707102138001:consigneeAddress", "order:orderno:CO201707102138001:platform" };
		List<String> hvals = jedis.hmget("orders", fields);
		hvals.forEach(hval -> {
			System.out.println(hval);
		});
	}

	@Test
	public void testHash2() {
		Map<String, String> vo1 = Maps.newHashMapWithExpectedSize(4);
		vo1.put("consignee", "琴弦子");
		vo1.put("consigneeAddress", "深圳市龙岗区");
		vo1.put("orderAmount", "32.2");

		Map<String, String> vo2 = Maps.newHashMapWithExpectedSize(4);
		vo2.put("consignee", "梁新叶");
		vo2.put("consigneeAddress", "深圳市龙岗区坂田街道同兴路");
		vo2.put("orderAmount", "3.1");

		Map<String, String> vo3 = Maps.newHashMapWithExpectedSize(4);
		vo3.put("consignee", "梁先富");
		vo3.put("consigneeAddress", "深圳市福田区竹子林");
		vo3.put("orderAmount", "8.6");

		jedis.hmset("CO201707102138001", vo1);
		jedis.expire("CO201707102138001", 120);
		jedis.hmset("CO201707102138002", vo2);
		jedis.hmset("CO201707102138003", vo3);
		jedis.hincrByFloat("CO201707102138001", "orderAmount", 1.1);
	}

	@Test
	public void testHash22() {
		Map<String, String> vo2 = jedis.hgetAll("CO201707102138002");
		System.out.println(vo2.size());

		String[] fields = { "consignee", "consigneeAddress", "orderAmount" };
		List<String> vo3 = jedis.hmget("CO201707102138003", fields);
		System.out.println(vo3.size());
	}
}

package vk.rico.redis.redisson;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RBucket;
import org.redisson.api.RBuckets;
import org.redisson.api.RKeys;
import org.redisson.api.RMap;

public class KeysTest extends BaseTest {

	@Test
	public void testRMap() {
		RMap<Object, Object> mymap = redissonClient.getMap("mymap");
		String name = mymap.getName();
		System.out.println("======testRMap : " + name);
	}

	@Test
	public void testRKeys() {
		RKeys rkeys = redissonClient.getKeys();
		Iterable<String> allKeys = rkeys.getKeys();
		for (Iterator<String> it = allKeys.iterator(); it.hasNext();) {
			String key = it.next();
			System.out.println("======testRKeys : " + key);
		}
	}

	@Test
	public void testGetKeys() {
		// String pattern = "h?llo"; //匹配1个字符
		// String pattern = "h*lo"; // 匹配多个字符
		// String pattern = "h[ae]llo"; // 匹配 hello 和 hallo, 但是不匹配 hillo
		// String pattern = "h[^e]llo"; // 匹配 hallo, hbllo, 但是不匹配 hello
		// String pattern = "h[a-e]llo"; // 匹配 hallo、 hbllo、hello
		String pattern = "*"; // 匹配所有key，相当于rkeys.getKeys();
		RKeys rkeys = redissonClient.getKeys();
		Iterable<String> allKeys = rkeys.getKeysByPattern(pattern);
		for (Iterator<String> it = allKeys.iterator(); it.hasNext();) {
			String key = it.next();
			System.out.println("======testKeys : " + key);
		}

		String randomKey = rkeys.randomKey();
		long keysAmount = rkeys.count();
		System.out.println("======testKeys : " + randomKey);
		System.out.println("======testKeys : " + keysAmount);
	}

	@Test
	public void testDelKeys() throws Exception {
		String pattern = "h?llo"; // 匹配1个字符
		RKeys rkeys = redissonClient.getKeys();

		Long count = rkeys.deleteByPattern(pattern);
		System.out.println("======testDelKeys : " + count);

		// RFuture<Long> deleteAsync = rkeys.deleteByPatternAsync(pattern);
		// Long long1 = deleteAsync.get(5, TimeUnit.SECONDS);
		// System.out.println("======testDelKeys : " + long1);
	}

	/**
	 * RBucket表示redis中的字符串数据
	 */
	@Test
	public void testRBucket() {
		// 设置一个元素
		RBucket<String> bucket = redissonClient.getBucket("username");
		// bucket.set("liangxianfu");
		bucket.set("liangxianfu", 60, TimeUnit.SECONDS);
		String string = bucket.get();
		System.out.println(string);

		// 设置多个元素
		Map<String, Object> values = new HashMap<>(4);
		values.put("sex", "男");
		values.put("age", 30);
		RBuckets buckets = redissonClient.getBuckets();
		buckets.set(values);
		Map<String, Object> map = buckets.get("sex", "age", "username");
		System.out.println(map.getOrDefault("age", -1L));
		System.out.println(map.getOrDefault("username", "unknow"));
	}

	@Test
	public void testRBucket2() {
		OrderPO po1 = new OrderPO();
		po1.setOrderNo("CO201707101842001");
		po1.setPlatform("ALI");
		po1.setPhone("18566696280");
		po1.setConsignee("梁先富");
		po1.setConsigneeAddress("深圳市龙岗区坂田街道新天下工业区西门");
		po1.setOrderAmount(3.21F);

		// 设置一个元素
		RBucket<OrderPO> bucket = redissonClient.getBucket("orderItem");
		bucket.set(po1);
	}

	@Test
	public void testAtomicLong() {
		RAtomicLong atomicLong = redissonClient.getAtomicLong("myage");
		long addAndGet = atomicLong.addAndGet(2L);
		System.out.println("======testAtomicLong : " + addAndGet);

		atomicLong.set(20);
	}
}

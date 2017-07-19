package vk.rico.redis.redisson;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import java.util.Set;

import org.junit.Test;
import org.redisson.api.RKeys;
import org.redisson.api.RMap;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class RMapTest extends BaseTest {

	@Test
	public void testExport() {
		List<String> dataList = new ArrayList<>();
		dataList.add("雲鸡爪");
		exportCsv(new File("H:/test/test.csv"), dataList);
	}

	public void export(File file, List<String> dataList) throws Exception {
		ByteArrayOutputStream output = new ByteArrayOutputStream(1024);
		for (String data : dataList) {
			output.write(data.getBytes("UTF-8"));
		}
		FileOutputStream fo = new FileOutputStream(file);
		fo.write(output.toByteArray());
		fo.close();

	}

	public static boolean exportCsv(File file, List<String> dataList) {
		boolean isSucess = false;

		FileOutputStream out = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		try {
			out = new FileOutputStream(file);
			// osw = new OutputStreamWriter(out, "UTF-8");
			osw = new OutputStreamWriter(out);
			osw.write(new String(new byte[] { (byte) 0xEF, (byte) 0xBB, (byte) 0xBF }));
			bw = new BufferedWriter(osw);
			if (dataList != null && !dataList.isEmpty()) {
				for (String data : dataList) {
					bw.append(data).append("\r");
				}
			}
			isSucess = true;
		} catch (Exception e) {
			isSucess = false;
		} finally {
			if (bw != null) {
				try {
					bw.close();
					bw = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (osw != null) {
				try {
					osw.close();
					osw = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
					out = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return isSucess;
	}

	@Test
	public void testRMapput() {
		RMap<String, Object> mymap = redissonClient.getMap("mymap");
		mymap.put("lili", 12);
		mymap.put("lilei", "我是lilei");

		mymap.fastPut("height", 75.2F);
		Object putIfAbsent = mymap.putIfAbsent("lili", "我是lili"); // 可以不存在是，则添加；存在时，则不添加
		System.out.println(putIfAbsent);
	}

	/**
	 * key设计
	 */
	@Test
	public void testRMapput1() {
		OrderPO po1 = new OrderPO();
		po1.setOrderNo("CO201707101842001");
		po1.setPlatform("ALI");
		po1.setPhone("18566696280");
		po1.setConsignee("梁先富");
		po1.setConsigneeAddress("深圳市龙岗区坂田街道新天下工业区西门");
		po1.setOrderAmount(3.21F);

		OrderPO po2 = new OrderPO();
		po2.setOrderNo("CO201707101846001");
		po2.setPlatform("WISH");
		po2.setPhone("15989419275");
		po2.setConsignee("梁新叶");
		po2.setConsigneeAddress("深圳市龙岗区坂田街道同兴路");
		po2.setOrderAmount(8.91F);

		OrderPO po3 = new OrderPO();
		po3.setOrderNo("CO201707101846002");
		po3.setPlatform("EBY");
		po3.setPhone("13173515369");
		po3.setConsignee("琴弦子");
		po3.setConsigneeAddress("深圳市福田区竹子林");
		po3.setOrderAmount(13.51F);

		HashMap<String, Object> values = Maps.newHashMapWithExpectedSize(64);
		values.putAll(po1.getEntry());
		values.putAll(po2.getEntry());
		values.putAll(po3.getEntry());

		RMap<String, Object> orders = redissonClient.getMap("orders");
		orders.putAll(values);
	}

	/**
	 * key设计
	 */
	@Test
	public void testRMapput11() {
		OrderPO po1 = new OrderPO();
		po1.setOrderNo("CO201707101842001");
		po1.setPlatform("ALI");
		po1.setPhone("18566696280");
		po1.setConsignee("梁先富");
		po1.setConsigneeAddress("深圳市龙岗区坂田街道新天下工业区西门");
		po1.setOrderAmount(3.21F);

		OrderPO po2 = new OrderPO();
		po2.setOrderNo("CO201707101846001");
		po2.setPlatform("WISH");
		po2.setPhone("15989419275");
		po2.setConsignee("梁新叶");
		po2.setConsigneeAddress("深圳市龙岗区坂田街道同兴路");
		po2.setOrderAmount(8.91F);

		OrderPO po3 = new OrderPO();
		po3.setOrderNo("CO201707101846002");
		po3.setPlatform("EBY");
		po3.setPhone("13173515369");
		po3.setConsignee("琴弦子");
		po3.setConsigneeAddress("深圳市福田区竹子林");
		po3.setOrderAmount(13.51F);

		HashMap<String, Object> values = Maps.newHashMapWithExpectedSize(64);
		values.putAll(po1.getEntry2());
		values.putAll(po2.getEntry2());
		values.putAll(po3.getEntry2());

		RMap<String, Object> orders = redissonClient.getMap("orders");
		orders.putAll(values);
	}

	/**
	 * key设计
	 */
	@Test
	public void testRMapput12() {
		OrderPO po1 = new OrderPO();
		po1.setOrderNo("CO201707101842001");
		po1.setPlatform("ALI");
		po1.setPhone("18566696280");
		po1.setConsignee("梁先富");
		po1.setConsigneeAddress("深圳市龙岗区坂田街道新天下工业区西门");
		po1.setOrderAmount(3.21F);

		OrderPO po2 = new OrderPO();
		po2.setOrderNo("CO201707101846001");
		po2.setPlatform("WISH");
		po2.setPhone("15989419275");
		po2.setConsignee("梁新叶");
		po2.setConsigneeAddress("深圳市龙岗区坂田街道同兴路");
		po2.setOrderAmount(8.91F);

		OrderPO po3 = new OrderPO();
		po3.setOrderNo("CO201707101846002");
		po3.setPlatform("EBY");
		po3.setPhone("13173515369");
		po3.setConsignee("琴弦子");
		po3.setConsigneeAddress("深圳市福田区竹子林");
		po3.setOrderAmount(13.51F);

		HashMap<String, OrderPO> values = Maps.newHashMapWithExpectedSize(64);
		values.put(po1.getOrderNo(), po1);
		values.put(po2.getOrderNo(), po2);
		values.put(po3.getOrderNo(), po3);

		RMap<String, OrderPO> orders = redissonClient.getMap("orders");
		orders.putAll(values);
	}

	@Test
	public void testRMapput122() {
		OrderPO po1 = new OrderPO();
		po1.setOrderNo("CO201707101842001");
		po1.setPlatform("ALI");
		po1.setPhone("18566696280");
		po1.setConsignee("梁先富");
		po1.setConsigneeAddress("深圳市龙岗区坂田街道新天下工业区西门");
		po1.setOrderAmount(3.21F);

		OrderPO po2 = new OrderPO();
		po2.setOrderNo("CO201707101846001");
		po2.setPlatform("WISH");
		po2.setPhone("15989419275");
		po2.setConsignee("梁新叶");
		po2.setConsigneeAddress("深圳市龙岗区坂田街道同兴路");
		po2.setOrderAmount(8.91F);

		OrderPO po3 = new OrderPO();
		po3.setOrderNo("CO201707101846002");
		po3.setPlatform("EBY");
		po3.setPhone("13173515369");
		po3.setConsignee("琴弦子");
		po3.setConsigneeAddress("深圳市福田区竹子林");
		po3.setOrderAmount(13.51F);

		RMap<String, Object> map1 = redissonClient.getMap("CO201707101842001");
		map1.putAll(po1.getValues());
		map1.expire(120, TimeUnit.SECONDS);
		RMap<String, Object> map2 = redissonClient.getMap("CO201707101846001");
		map2.putAll(po2.getValues());
		RMap<String, Object> map3 = redissonClient.getMap("CO201707101846002");
		map3.putAll(po3.getValues());
	}

	@Test
	public void testRMapput1222() {
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
//		RMap<String, Object> map1 = redissonClient.getMap("CO201707101846002");
//		// Set<String> keys = map1.readAllKeySet();
//		// keys.forEach(key -> {
//		// Object object = map1.get(key);
//		// System.out.println(object);
//		// });
//		Set<Entry<String, Object>> entrySet = map1.readAllEntrySet();
//		entrySet.forEach(entry -> {
//			System.out.println(entry.getKey() + "\t" + entry.getValue());
//		});
	}

	/**
	 * 根据订单编号获取订单信息
	 * 
	 * @param orderNO
	 *            订单编号
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testGetOrderByOrderNO() {
		RMap<String, Object> orders = redissonClient.getMap("orders");
		Map<String, Object> orderMap = (Map<String, Object>) orders.get("order:orderno:CO201707101846001");
		String consignee = (String) orderMap.get("consignee");
		System.out.println(consignee);
	}

	@Test
	public void testGetOrderByOrderNO2() {
		RMap<String, OrderPO> orders = redissonClient.getMap("orders");
		OrderPO orderPo = orders.get("CO201707101846001");
		System.out.println(orderPo.getConsigneeAddress());
	}

	@Test
	public void testRMapput2() {
		List<OrderVO> orders = Lists.newArrayListWithCapacity(3);
		OrderVO vo1 = new OrderVO();
		vo1.setId(1001);
		vo1.setOrderNO("CO201707101524");
		vo1.setBuyer("梁先富");

		OrderVO vo2 = new OrderVO();
		vo2.setId(1002);
		vo2.setOrderNO("CO201707101524");
		vo2.setBuyer("李蕾");

		OrderVO vo3 = new OrderVO();
		vo3.setId(1003);
		vo3.setOrderNO("CO201707101525");
		vo3.setBuyer("韩梅梅");

		orders.add(vo1);
		orders.add(vo2);
		orders.add(vo3);

		// 用jackson将List<OrderVO>序列化成json字符串，以hash数据结构存储到redis中
		// key是orders，值是List<OrderVO>序列化之后的json字符串
		RMap<String, Object> ordersmap = redissonClient.getMap("orders");
		Object obj = ordersmap.put("orders", orders);
		System.out.println(obj);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testRMapput3() {
		RMap<String, Object> ordersmap = redissonClient.getMap("orders");
		List<OrderVO> orders = (List<OrderVO>) ordersmap.get("orders");
		orders.forEach(ordervo -> {
			System.out.println(ordervo.getOrderNO());
		});
	}

	@Test
	public void testRMapget() {
		RMap<String, Object> mymap = redissonClient.getMap("mymap");
		Object object = mymap.get("lilei");
		System.out.println("======testRMapget : " + object);

		Set<String> keys = new HashSet<String>(8);
		keys.add("lili");
		keys.add("lilei");
		Map<String, Object> allkeys = mymap.getAll(keys);
		System.out.println(allkeys.size());
	}
}

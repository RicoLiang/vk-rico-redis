package vk.rico.redis.springdataredis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import vk.rico.redis.springdataredis.vo.AliexpressOrderVO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class HashTest {

	@Autowired
	private HashMapping hashMapping;

//	@Test
//	public void testHashMapping() {
//		AliexpressOrderVO saveVo = new AliexpressOrderVO();
//		saveVo.setOrderNo("CO201707101842001");
//		saveVo.setPlatform("ALI");
//		saveVo.setPhone("18566696280");
//		saveVo.setConsignee("梁先富");
//		saveVo.setConsigneeAddress("深圳市龙岗区坂田街道新天下工业区西门");
//		saveVo.setOrderAmount(3.21F);
//
//		String key = "CO201707101842001";
//		hashMapping.writeHash(key, saveVo);
//
//		AliexpressOrderVO loadVo = hashMapping.loadHash(key);
//		Assert.assertEquals(saveVo, loadVo);
//	}

	@Test
	public void testHashMapping2() {
		AliexpressOrderVO saveVo = new AliexpressOrderVO();
		saveVo.setOrderNo("CO201707101846002");
		saveVo.setPlatform("EBY");
		saveVo.setPhone("13173515369");
		saveVo.setConsignee("琴弦子");
		saveVo.setConsigneeAddress("深圳市福田区竹子林");
		saveVo.setOrderAmount(13.51F);

		String key = "CO201707101842001";
		hashMapping.writeHash2(key, saveVo);

		AliexpressOrderVO loadVo = hashMapping.loadHash2(key);
		System.out.println(loadVo);
		Assert.assertEquals(saveVo.getOrderNo(), loadVo.getOrderNo());
	}
}

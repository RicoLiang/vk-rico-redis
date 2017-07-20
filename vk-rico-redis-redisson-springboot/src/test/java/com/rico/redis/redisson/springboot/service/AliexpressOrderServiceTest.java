package com.rico.redis.redisson.springboot.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rico.redis.redisson.springboot.BaseTest;
import com.rico.redis.redisson.springboot.RedissonApplication;
import com.rico.redis.redisson.springboot.vo.AliexpressOrderVO;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RedissonApplication.class)
public class AliexpressOrderServiceTest extends BaseTest {

	@Autowired
	private IAliexpressOrderService aliexpressOrderService;

	@Test
	public void testGetAliOrderByOrderNO() {
		try {
			AliexpressOrderVO aliOrderVo = aliexpressOrderService.getAliOrderByOrderNO("CO2017072014510101");
			String consigneeAddress = aliOrderVo.getConsigneeAddress();
			System.out.println(consigneeAddress);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
}

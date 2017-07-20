package com.rico.redis.redisson.springboot.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.rico.redis.redisson.springboot.service.IAliexpressOrderService;
import com.rico.redis.redisson.springboot.vo.AliexpressOrderVO;

@Service("aliexpressOrderService")
public class AliexpressOrderServiceImpl implements IAliexpressOrderService {

	@Override
	@Cacheable(cacheNames = "orders")
	public AliexpressOrderVO getAliOrderByOrderNO(String orderNO) throws Exception {
		if (StringUtils.isBlank(orderNO)) {
			throw new IllegalArgumentException("orderNO参数不能为空");
		}

		AliexpressOrderVO orderVo = new AliexpressOrderVO();
		orderVo.setOrderNo("CO201707101846001");
		orderVo.setPlatform("WISH");
		orderVo.setPhone("15989419275");
		orderVo.setConsignee("梁新叶");
		orderVo.setConsigneeAddress("深圳市龙岗区坂田街道同兴路");
		orderVo.setOrderAmount(8.91F);
		return orderVo;
	}
}

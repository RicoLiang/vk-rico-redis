package com.rico.redis.redisson.springboot.service;

import com.rico.redis.redisson.springboot.vo.AliexpressOrderVO;

public interface IAliexpressOrderService {

	/**
	 * 通过订单编号查询订单
	 * 
	 * @param orderNO
	 *            订单编号
	 * @return
	 * @throws Exception
	 */
	AliexpressOrderVO getAliOrderByOrderNO(String orderNO) throws Exception;
}

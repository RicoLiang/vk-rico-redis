package com.rico.redis.redisson.springboot.vo;

import java.io.Serializable;

public class AliexpressOrderVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2380726631526480861L;

	/**
	 * 订单编号
	 */
	private String orderNo;

	/**
	 * 平台
	 */
	private String platform;

	/**
	 * 收货人
	 */
	private String consignee;

	/**
	 * 收货人地址
	 */
	private String consigneeAddress;

	/**
	 * 收货人联系电话
	 */
	private String phone;

	/**
	 * 订单金额
	 */
	private Float orderAmount;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getConsigneeAddress() {
		return consigneeAddress;
	}

	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Float getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Float orderAmount) {
		this.orderAmount = orderAmount;
	}
}

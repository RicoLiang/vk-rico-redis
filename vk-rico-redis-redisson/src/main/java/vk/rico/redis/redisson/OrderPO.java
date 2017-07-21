package vk.rico.redis.redisson;

public class OrderPO {

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

//	/**
//	 * 表名:主键字段(或非空唯一性字段):主键字段值
//	 * 
//	 * @return
//	 */
//	public String getKey() {
//		StringBuffer sbKey = new StringBuffer("order:orderno:");
//		sbKey.append(this.getOrderNo());
//		return sbKey.toString();
//	}
//
//	public Map<String, Object> getEntry() {
//		String keyPrefix = "order:orderno:" + this.getOrderNo();
//		Map<String, Object> values = Maps.newHashMapWithExpectedSize(8);
//		values.put(keyPrefix + ":platform", this.getPlatform());
//		values.put(keyPrefix + ":consignee", this.getConsignee());
//		values.put(keyPrefix + ":consigneeaddress", this.getConsigneeAddress());
//		values.put(keyPrefix + ":phone", this.getPhone());
//		values.put(keyPrefix + ":orderamount", this.getOrderAmount());
//		return values;
//	}
//
//	public Map<String, Object> getEntry2() {
//		Map<String, Object> values = Maps.newHashMapWithExpectedSize(8);
//		values.put("platform", this.getPlatform());
//		values.put("consignee", this.getConsignee());
//		values.put("consigneeaddress", this.getConsigneeAddress());
//		values.put("phone", this.getPhone());
//		values.put("orderamount", this.getOrderAmount());
//
//		Map<String, Object> values2 = Maps.newHashMapWithExpectedSize(4);
//		String keyPrefix = "order:orderno:" + this.getOrderNo();
//		values2.put(keyPrefix, values);
//		return values2;
//	}
//
//	public Map<String, Object> getValues() {
//		Map<String, Object> values = Maps.newHashMapWithExpectedSize(8);
//		values.put("platform", this.getPlatform());
//		values.put("consignee", this.getConsignee());
//		values.put("consigneeaddress", this.getConsigneeAddress());
//		values.put("phone", this.getPhone());
//		values.put("orderamount", this.getOrderAmount());
//		return values;
//	}
	
//	private OrderPO child;
//
//	public OrderPO getChild() {
//		return child;
//	}
//
//	public void setChild(OrderPO child) {
//		this.child = child;
//	}
}

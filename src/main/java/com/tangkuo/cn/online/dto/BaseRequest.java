package com.tangkuo.cn.online.dto;

/**
 * 请求实体父类
 * 
 * @author 61650
 *
 */
public class BaseRequest {
	/** orderId 订单号: 严格遵守格式：8位日期YYYYMMDD+8位流水 **/
	private String orderId;

	/** requestTime 请求时间 String M 格式：yyyyMMddHHmmss */
	private String requestTime;

	/**
	 * 获取orderId 订单号: 严格遵守格式：8位日期YYYYMMDD+8位流水
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * 设置orderId 订单号: 严格遵守格式：8位日期YYYYMMDD+8位流水
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * 获取 requestTime 请求时间 String M 格式：yyyyMMddHHmmss
	 */
	public String getRequestTime() {
		return requestTime;
	}

	/**
	 * 设置 requestTime 请求时间 String M 格式：yyyyMMddHHmmss
	 */
	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}

}

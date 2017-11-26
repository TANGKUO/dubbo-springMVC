package com.tangkuo.cn.online.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 請求接口組織參數實體類
 * 
 * @author 61650
 *
 */
public class OrderQueryReq implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 订单号，唯一性
	private String orderId;

	// 請求時間
	private String requestTime;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}

package com.tangkuo.cn.online.dto;

/**
 * 接收參數響應結果實體類
 * 
 * @author 61650
 *
 */
public class OrderQueryResp extends BaseResponse {

	private String orderId;
	private String amount;
	private String remark;
	private String merId;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getMerId() {
		return merId;
	}

	public void setMerId(String merId) {
		this.merId = merId;
	}

}

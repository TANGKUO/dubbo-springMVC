package com.tangkuo.cn.online.enums;

/**
 * 
 * @author 61650 
 *
 */
public enum TransCode {
	/**
	 * 成功:0000
	 */
	TRANS_0000("0000", "成功"),
	/**
	 * 失败:9999
	 */
	TRANS_9999("9999", "失败"),
	/**
	 * 通用未知錯誤:1002
	 */
	TRANS_1002("1002", "通用未知錯誤"),

	;

	private String code;
	private String desc;

	private TransCode(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}

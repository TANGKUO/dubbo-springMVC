package com.tangkuo.cn.online.enums;

/**
 * 
 * @ClassName: ApiCode
 * @Description: (API回应编码)
 * @author 
 *
 */
public enum ApiCode {
	// 请求成功
	API_OK200("200", "OK"),
	// 请求失敗
	API_OK("500", "error"), 
	 // 客户端请求的语法错误，服务器无法理解
	API_ERR400("400", "Bad Request")
	;

	private String code;
	private String desc;

	private ApiCode(String code, String desc) {
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

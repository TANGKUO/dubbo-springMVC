package com.tangkuo.cn.online.dto;

/**
 * 
 * @ClassName: BaseResponse
 * @Description: (基础响应实体类)
 * @author
 *
 */
public class BaseResponse {

	private String code;

	private String message;

	private String respDate;

	public String getRespDate() {
		return respDate;
	}

	public void setRespDate(String respDate) {
		this.respDate = respDate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

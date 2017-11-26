package com.tangkuo.cn.online.constants;

/**
 * 自定义业务逻辑异常类
 * 
 * @author 61650 
 *
 */
public class HandlerException extends Exception {

	private static final long serialVersionUID = 1L;

	private String code;

	private String message;

	public HandlerException(String code, String message) {
		super();
		this.code = code;
		this.message = message;
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

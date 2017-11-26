package com.tangkuo.cn.online.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author 61650
 *
 */
public class MessageUtil {

	protected static final Logger logger = LoggerFactory.getLogger(MessageUtil.class);

	public static void logBankResp(String requestType, String respMsg) {
		logger.debug(String.format("requestType[%s];respMsg[%s]", requestType, respMsg));
	}
}

package com.tangkuo.cn.online.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author 61650
 *
 */
public class ConfigUtil {

	public static String getConfigFilePath(String fileName) {

		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		if (StringUtils.isEmpty(fileName)) {
			return null;
		}
		return cl.getResource(fileName).getFile();
	}
}

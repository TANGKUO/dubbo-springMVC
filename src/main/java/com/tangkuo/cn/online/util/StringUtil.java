package com.tangkuo.cn.online.util;

import java.util.UUID;

public class StringUtil {
	/**
	 * 
	 * @Title: getUUID
	 * @Description: (UUID自动生成32位唯一键)
	 * @return String 返回类型
	 */
	public static String getUUID() {
		String uuid = UUID.randomUUID().toString();
		// 去掉“-”符号
		return uuid.replaceAll("-", "");
	}

}

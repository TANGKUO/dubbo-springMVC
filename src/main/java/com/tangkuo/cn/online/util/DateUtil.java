package com.tangkuo.cn.online.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author 61650
 *
 */
public class DateUtil {

	public static final String PATTERN_STANDARD08W = "yyyyMMdd";
	public static final String PATTERN_STANDARD12W = "yyyyMMddHHmm";
	public static final String PATTERN_STANDARD14W = "yyyyMMddHHmmss";
	public static final String PATTERN_STANDARD17W = "yyyyMMddHHmmssSSS";

	public static final String PATTERN_STANDARD10H = "yyyy-MM-dd";
	public static final String PATTERN_STANDARD16H = "yyyy-MM-dd HH:mm";
	public static final String PATTERN_STANDARD19H = "yyyy-MM-dd HH:mm:ss";

	public static final String PATTERN_STANDARD10X = "yyyy/MM/dd";
	public static final String PATTERN_STANDARD16X = "yyyy/MM/dd HH:mm";
	public static final String PATTERN_STANDARD19X = "yyyy/MM/dd HH:mm:ss";

	/**
	 * 日期转字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date, String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

	/**
	 * 解析字符串的文本，以生成一个日期。
	 * 
	 * @param source
	 *            待解析的字符串
	 * @param pattern
	 *            描述日期和时间格式的模式
	 * @return 解析字符串得到的Date。
	 */
	public static Date parse(String source, String pattern) {
		if (source == null) {
			return null;
		}
		DateFormat df = new SimpleDateFormat(pattern);
		try {
			return df.parse(source);
		} catch (ParseException e) {
			throw new IllegalArgumentException("使用模式 " + pattern + " 无法解析字符串 " + source + " 生成日期", e);
		}
	}

	/**
	 * 
	 * @Title: formatDate @Description: (根据传入的指定格式格式化日期返回) @param date
	 * Date @param format String @return String 返回类型 @throws
	 */
	public static String formatDate(Date date, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}

	/**
	 * 
	 * @Title: formatNow @Description: (根据传入的指定格式格式化当前日期) @param @param
	 * format @param @return 设定文件 @return String 返回类型 @throws
	 */
	public static String formatNow(String format) {
		return formatDate(new Date(), format);
	}

	/**
	 * @Title: getWantDate
	 * @Description: 获取想要的时间格式
	 * @author YFB
	 * @param dateStr
	 * @param wantFormat
	 * @return
	 */
	public static String getWantDate(String dateStr, String wantFormat) {
		if (!"".equals(dateStr) && dateStr != null) {
			String pattern = PATTERN_STANDARD14W;
			int len = dateStr.length();
			switch (len) {
			case 8:
				pattern = PATTERN_STANDARD08W;
				break;
			case 12:
				pattern = PATTERN_STANDARD12W;
				break;
			case 14:
				pattern = PATTERN_STANDARD14W;
				break;
			case 17:
				pattern = PATTERN_STANDARD17W;
				break;
			case 10:
				pattern = (dateStr.contains("-")) ? PATTERN_STANDARD10H : PATTERN_STANDARD10X;
				break;
			case 16:
				pattern = (dateStr.contains("-")) ? PATTERN_STANDARD16H : PATTERN_STANDARD16X;
				break;
			case 19:
				pattern = (dateStr.contains("-")) ? PATTERN_STANDARD19H : PATTERN_STANDARD19X;
				break;
			default:
				pattern = PATTERN_STANDARD14W;
				break;
			}
			SimpleDateFormat sdf = new SimpleDateFormat(wantFormat);
			try {
				SimpleDateFormat sdfStr = new SimpleDateFormat(pattern);
				Date date = sdfStr.parse(dateStr);
				dateStr = sdf.format(date);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dateStr;
	}
}

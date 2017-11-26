package com.tangkuo.cn.online.util.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangkuo.cn.online.util.StringParam;

/**
 * 
 * @author 61650
 *
 */
public class StringParamTest {
	protected static final Logger logger = LoggerFactory.getLogger(StringParamTest.class);

	@Test
	public void testParserPara() {
		String str = "encryptData=sS%3D";
		String name = "encryptData";
		logger.info("encryptStr=" + StringParam.parserPara(str, name));

		String str2 = "a=1&&b=2";
		String name2 = "a";
		logger.info("a=" + StringParam.parserPara(str2, name2));
	}

	@Test
	public void test() {
		int number = (int) 0.01;
		logger.info("number=" + number);
	}
}

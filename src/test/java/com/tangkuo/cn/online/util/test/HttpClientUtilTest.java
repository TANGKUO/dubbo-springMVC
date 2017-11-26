package com.tangkuo.cn.online.util.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangkuo.cn.online.util.HttpClientUtil;
import com.tangkuo.cn.online.util.StringUtil;

/**
 * 
 * @ClassName: HttpClientUtilTest
 * @Description: (HttpClientUtil测试类)
 * @author
 */
public class HttpClientUtilTest {
	protected static final Logger logger = LoggerFactory.getLogger(HttpClientUtilTest.class);

	/**
	 * 
	 * @Title: testHttpPost
	 * @Description: (测试httpClientUtil)
	 * 
	 * @return void 返回类型
	 * @throws Exception
	 */
	@Test
	public void testDoPost() throws Exception {
		String openNotifyUrl = "http://192.168.1.116:8080/dubbo/api";
		String acceptBizJrnNo = StringUtil.getUUID();
		String requestStr = "{\"acceptBizJrnNo\": " + acceptBizJrnNo + ",\"origAcceptBizJrnNo\": \"2017080815490002\"}";
		HttpClientUtil httpClientUtil = new HttpClientUtil();
		String result = httpClientUtil.doPost(openNotifyUrl, requestStr);
		System.out.println(result);
	}

}

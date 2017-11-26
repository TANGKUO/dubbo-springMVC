package com.tangkuo.cn.online.controller.test;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.tangkuo.cn.online.base.SpringConfigContextLoader;
import com.tangkuo.cn.online.controller.MonitorServerController;

/**
 * 
 * @ClassName: MonitorServerControllerTest
 * @Description: (测试MonitorServerController类)
 * @author
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = SpringConfigContextLoader.class)
public class MonitorServerControllerTest {
	protected static final Logger logger = LoggerFactory.getLogger(MonitorServerControllerTest.class);

	@Autowired
	MonitorServerController monitorServerController = new MonitorServerController();

	/**
	 * 
	 * @Title: testApi
	 * @Description: (测试监控系统api接口)
	 * 
	 * @return void 返回类型
	 * @throws IOException
	 */
	@Test
	public void testApi() throws IOException {
		MockHttpServletResponse response = new MockHttpServletResponse();

		// 请求必填项
		String reqStr = "testDubbo";
		// 请求非必填项
		String reqJsonStr = JSON.toJSONString(reqStr);
		logger.info("reqJsonStr=" + reqJsonStr);
		monitorServerController.api(reqJsonStr, response);
		String resString = response.getContentAsString();
		logger.info("MonitorServerControllerTest.testApi,resString:【{}】", resString);

	}

}

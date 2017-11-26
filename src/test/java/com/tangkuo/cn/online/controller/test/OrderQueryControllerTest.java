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
import com.alibaba.fastjson.JSONObject;
import com.tangkuo.cn.online.base.BaseTest;
import com.tangkuo.cn.online.base.SpringConfigContextLoader;
import com.tangkuo.cn.online.constants.Constants;
import com.tangkuo.cn.online.controller.OrderQueryController;
import com.tangkuo.cn.online.dto.OrderQueryReq;
import com.tangkuo.cn.online.enums.TransCode;
import com.tangkuo.cn.online.util.DateUtil;

/**
 * 
 * @ClassName: OrderQueryControllerTest
 * @Description: (测试OrderQueryController类)
 * @author 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = SpringConfigContextLoader.class)
public class OrderQueryControllerTest extends BaseTest {
	protected static final Logger logger = LoggerFactory.getLogger(OrderQueryControllerTest.class);

	@Autowired
	OrderQueryController orderQueryController = new OrderQueryController();

	/**
	 * 
	 * @Title: testOrderQuery
	 * @Description: (测试接口)
	 * 
	 * @return void 返回类型
	 * @throws IOException
	 */
	@Test
	public void testOrderQuery() throws IOException {
		OrderQueryReq orderQuery = new OrderQueryReq();
		MockHttpServletResponse response = new MockHttpServletResponse();
		JSONObject jsonObject = new JSONObject();

		// 请求必填项,注意查询订单号必须与定点发送请求时间对应才能查询成功
		orderQuery.setOrderId("2re222c5cf3d42dea69b28bf3a549ky4");
		orderQuery.setRequestTime(DateUtil.formatNow(DateUtil.PATTERN_STANDARD14W));

		// 请求非必填项
		String reqJsonStr = JSON.toJSONString(orderQuery);
		logger.info("reqJsonStr=" + reqJsonStr);
		jsonObject = orderQueryController.orderQuery(orderQuery, response);
		logger.info(jsonObject.toString());

		// 判断查询订单是否(支付/退款,退货)成功.
		if (!jsonObject.isEmpty()) {
			String queryId = jsonObject.getString("queryId");
			if (TransCode.TRANS_0000.getCode().equals(jsonObject.get(Constants.RETURN_CODE))) {
				logger.info("OrderQueryControllerTest.testOrderQuery  is success ,queryId:【{}】", queryId);
			} else if (TransCode.TRANS_9999.equals(jsonObject.get(Constants.RETURN_CODE))) {
				logger.info("OrderQueryControllerTest.testOrderQuery  is failed ,queryId:【{}】", queryId);
			}
		}
	}
}

package com.tangkuo.cn.online.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tangkuo.cn.online.base.BaseController;
import com.tangkuo.cn.online.constants.Constants;
import com.tangkuo.cn.online.constants.HandlerException;
import com.tangkuo.cn.online.dto.OrderQueryReq;
import com.tangkuo.cn.online.enums.TransCode;

/**
 * 
 * @author 61650 
 *
 */
@Controller
@RequestMapping("/dubboTest")
public class OrderQueryController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(OrderQueryController.class);

	@ResponseBody
	@RequestMapping(value = "/orderQuery", method = RequestMethod.POST, consumes = "application/json")
	public JSONObject orderQuery(@RequestBody OrderQueryReq orderQuery, HttpServletResponse response)
			throws IOException {
		logger.info("OrderQueryController.orderQuery is start,【订单查询】获取平台产品-交易状态指令对象orderQuery:【{}】", orderQuery);
		JSONObject jsonResult = new JSONObject();
		String orderId = orderQuery.getOrderId();
		jsonResult.put("orderId", orderId);

		try {
			// 必须传入接口参数校验
			checkParam(orderQuery);

			// 获取后台接口上送参数值.
			String txnTime = orderQuery.getRequestTime();
			Map<String, String> data = new HashMap<String, String>();

			logger.info("OrderQueryController.orderQuery  txnTime:【{}】,data:【{}】", txnTime, data);
			jsonResult.put(Constants.RETURN_CODE.toString(), TransCode.TRANS_0000.getCode());
			jsonResult.put(Constants.RETURN_MESSAGE, TransCode.TRANS_0000.getDesc());
			logger.info("OrderQueryController.orderQuery is success,jsonResult:【{}】", jsonResult);
		} catch (HandlerException e) {
			logger.error(
					"OrderQueryController.orderQuery is error,orderId:【{}】,errorCode:【{}】,errorMessage:【{}】,Exception:【{}】",
					orderId, e.getCode(), e.getMessage(), e);
			jsonResult.put(Constants.RETURN_CODE.toString(), e.getCode());
			jsonResult.put(Constants.RETURN_MESSAGE, e.getMessage());
		}
		logger.info("OrderQueryController.orderQuery is end,jsonResult:【{}】", jsonResult);
		return jsonResult;
	}

	/**
	 * 
	 * @Title: checkParam
	 * @Description: (入参校验)
	 * @param orderQuery
	 *            OrderQueryReq
	 * @return void 返回类型
	 * @throws HandlerException
	 */
	private void checkParam(OrderQueryReq orderQuery) throws HandlerException {
		// 商户订单号 orderId M
		if (StringUtils.isBlank(orderQuery.getOrderId())) {
			throw new HandlerException(TransCode.TRANS_1002.getCode(), "商户订单号不能为空");
		}
		// 订单发送时间 txnTime M
		if (StringUtils.isBlank(orderQuery.getRequestTime())) {
			throw new HandlerException(TransCode.TRANS_1002.getCode(), "订单发送时间不能为空");
		}
	}
}

package com.tangkuo.cn.online.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tangkuo.cn.online.base.BaseController;
import com.tangkuo.cn.online.enums.ApiCode;

/**
 * 心跳監控服務器類
 * 
 * @author 61650 
 *
 */
@Controller
@RequestMapping("/api")
public class MonitorServerController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(MonitorServerController.class);

	/**
	 * 
	 * @Title: api
	 * @Description: (监控服务)
	 * @param api
	 *            String
	 * @param response
	 *            HttpServletResponse
	 * @return void 返回类型
	 * @throws IOException
	 */
	@RequestMapping("")
	public void api(String api, HttpServletResponse response) throws IOException {
		try {
			writeResult(Integer.valueOf(ApiCode.API_OK.getCode()), ApiCode.API_OK.getDesc(), response);
			log.info("MonitorServerController.api is success");
		} catch (Exception se) {
			log.error(se.getMessage());
			writeResult(Integer.valueOf(ApiCode.API_ERR400.getCode()), ApiCode.API_ERR400.getDesc(), response);
		}
	}

}

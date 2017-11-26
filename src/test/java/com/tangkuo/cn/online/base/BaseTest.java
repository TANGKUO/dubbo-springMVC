package com.tangkuo.cn.online.base;

import org.junit.After;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @ClassName: BaseTest
 * @Description: ()
 * @author
 * @date 2017年9月13日 下午5:33:32
 *
 */
public class BaseTest extends BaseController {
	protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

	/**
	 * 这个方法在每个方法执行之前都会执行一遍
	 */
	@Before()
	public void setup() {
		// 初始化加载配置文件信息
		// 从classpath加载app.properties文件
		logger.info("BaseTest.Before");
	}

	/**
	 * 
	 */
	@After()
	public void after() {
		logger.info("BaseTest.after");
	}
}

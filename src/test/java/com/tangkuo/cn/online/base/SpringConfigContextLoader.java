package com.tangkuo.cn.online.base;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextLoader;

/**
 * 
 * @ClassName: SpringConfigContextLoader
 * @Description: (SpringConfigContextLoader加载)
 * @author
 *
 */
public class SpringConfigContextLoader implements ContextLoader {
	private String[] springXmlList = { "spring-mvc.xml" };

	@Override
	public String[] processLocations(Class<?> clazz, String... locations) {
		return springXmlList;
	}

	@Override
	public ApplicationContext loadContext(String... locations) throws Exception {
		return new ClassPathXmlApplicationContext(locations);
	}
}

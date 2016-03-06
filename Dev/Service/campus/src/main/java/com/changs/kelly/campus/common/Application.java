package com.changs.kelly.campus.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	private static ApplicationContext ctx = null;
	static {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	public static ApplicationContext getContext() {
		return ctx;
	}

}

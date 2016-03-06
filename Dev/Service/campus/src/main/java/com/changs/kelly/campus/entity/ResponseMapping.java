package com.changs.kelly.campus.entity;

import java.util.HashMap;

public class ResponseMapping {
	private static HashMap<Integer, String> responseMapping = new HashMap<Integer, String>();

	private static void put(int code, String des) {
		responseMapping.put(code, des);
	}

	public static String getDes(int code) {
		if (responseMapping.containsKey(code)) {
			return responseMapping.get(code);
		}
		return "没有指定该code的描述, code=" + code;
	}

	static {
		/* 普通 */
		put(0, "success");
		put(-1, "fail");
	}
}

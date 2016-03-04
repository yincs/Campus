package com.changs.kelly.campus.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class Log {
	public static void infoRequest(HttpServletRequest request) {
		System.out.println(request.getRequestURL());
		System.out.println(request.getQueryString());
		System.out.println(request.getMethod());
		System.out.println(request.getRemoteAddr());
		System.out.println(request.getRemoteHost());
		System.out.println(request.getRemotePort());
		System.out.println(request.getLocalAddr());

		Enumeration<String> e = request.getHeaderNames();
		while (e.hasMoreElements()) {
			String name = (String) e.nextElement();
			String value = request.getHeader(name);
			System.out.println("enumeration:" + name + ":" + value);
		}

		System.out.println(request.getContentLength());
		System.out.println(request.getContentLengthLong());
		Enumeration<String> attributeNames = request.getParameterNames();
		while (attributeNames.hasMoreElements()) {
			String name = (String) attributeNames.nextElement();
			String value = request.getParameter(name);
			System.out.println("attribute:" + name + ":" + value);
		}

		try {
			InputStream stream = request.getInputStream();
			byte[] bs = new byte[1024];
			StringBuffer buffer = new StringBuffer();
			while ((stream.read(bs) != -1)) {
				buffer.append(new String(bs));
			}
			System.out.println(buffer.toString());

		} catch (IOException e1) {
			e1.printStackTrace();
		}

		System.out.println(request.toString());
	}
}

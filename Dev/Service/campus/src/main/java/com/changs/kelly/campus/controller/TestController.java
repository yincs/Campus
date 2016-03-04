package com.changs.kelly.campus.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.changs.kelly.campus.utils.Log;

@Controller
public class TestController {

	// value = "/welcome",
	@RequestMapping("/find")
	public String testController(HttpServletRequest request) {
		System.out.println();
		System.out.println(request.getParameter("userId"));
		Log.infoRequest(request);
		System.out.println("requestAddr :" + request.getRemoteAddr() + " => enter channel.appStart");
		System.out.println(request);
		System.out.println("哈哈");
		return "json";
	}
}

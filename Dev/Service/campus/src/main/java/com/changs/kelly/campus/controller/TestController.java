package com.changs.kelly.campus.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.changs.kelly.campus.common.BaseController;
import com.changs.kelly.campus.entity.ResponseData;
import com.changs.kelly.campus.entity.UserBean;
import com.changs.kelly.campus.service.UserService;
import com.changs.kelly.campus.utils.Log;

@Controller
public class TestController extends BaseController {

	@Autowired
	private UserService userService;

	// value = "/welcome",
	@RequestMapping(value = "/find", method = RequestMethod.POST)
	public @ResponseBody ResponseData testController(HttpServletRequest request, @RequestBody UserBean userBean) {
		System.out.println("哈哈");
		userService.test();
		// System.out.println("userTest:" + postBean);
		// System.out.println(request.getParameter("userId"));
		Log.infoRequest(request);
		// System.out.println("requestAddr :" + request.getRemoteAddr() + " =>
		// enter channel.appStart");
		// System.out.println(request);
		List<UserBean> userBeans = new ArrayList<UserBean>();
		for (int i = 0; i < 5; i++) {
			userBeans.add(new UserBean("pass" + i, "name" + i));
		}
		return getErrorResponseData(123);
	}
}

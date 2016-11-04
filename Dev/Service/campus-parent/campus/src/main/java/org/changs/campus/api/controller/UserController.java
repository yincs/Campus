package org.changs.campus.api.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.changs.campus.base.AppResp;
import org.changs.campus.base.BaseController;
import org.changs.campus.domain.User;
import org.changs.campus.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	private static final Logger log = Logger.getLogger(UserController.class);
	
	@Resource
	private UserService userService;
	
	@ResponseBody
	@RequestMapping("/query")
	public AppResp<Object> queryById(@RequestParam int id) {
		log.debug("id = " + id);
		return userService.selectOne(id);
	}
	@ResponseBody
	@RequestMapping("/modify")
	public  AppResp<Object> modify(@RequestBody User user) {
		return userService.updateOne(user);
	}
}

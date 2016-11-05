package org.changs.campus.api.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.changs.campus.api.valid.ValidUserModify;
import org.changs.campus.base.AppResp;
import org.changs.campus.base.BaseController;
import org.changs.campus.domain.User;
import org.changs.campus.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	
	private static final Logger log = Logger.getLogger(UserController.class);

	@Resource
	private UserService userService;
	
	@ResponseBody
	@RequestMapping("/query/{id}")
	public AppResp<Object> queryById(@PathVariable int id) {
		return userService.selectOne(id);
	}

	@ResponseBody
	@RequestMapping("/modify")
	public AppResp<Object> modify(@RequestBody @Validated(ValidUserModify.class) User user) {
		return userService.updateOne(user);
	}
}

package org.changs.campus.api.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.changs.campus.core.entry.LoginRes;
import org.changs.campus.core.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/account")
public class AccountController extends BaseController {

	private static final Logger log = Logger.getLogger(AccountController.class);

	@Resource
	private AccountService accountService;

	@ResponseBody
	@RequestMapping("/login")
	public String login(@Valid @RequestBody LoginRes loginRes) {
		log.debug("start login");
		accountService.login(loginRes);
		return "succss";
	}
}

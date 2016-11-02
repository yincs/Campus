package org.changs.campus.api;

import javax.annotation.Resource;

import org.changs.campus.base.AppResp;
import org.changs.campus.base.BaseController;
import org.changs.campus.domain.Account;
import org.changs.campus.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/account")
public class AccountController extends BaseController {

	@Resource
	private AccountService accountService;

	@RequestMapping("/login")
	@ResponseBody
	public AppResp<Object> login(@RequestBody(required = true) Account account) {
		return accountService.login(account);
	}

	@RequestMapping("/register")
	@ResponseBody
	public AppResp<Object> register(@RequestBody(required = true) Account account) {
		return accountService.register(account);
	}
}

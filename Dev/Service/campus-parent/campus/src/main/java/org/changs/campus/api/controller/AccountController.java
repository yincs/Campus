package org.changs.campus.api.controller;

import javax.annotation.Resource;

import org.changs.campus.api.valid.ValidAccountLogin;
import org.changs.campus.api.valid.ValidAccountRegister;
import org.changs.campus.base.AppResp;
import org.changs.campus.base.BaseController;
import org.changs.campus.domain.Account;
import org.changs.campus.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
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
	public AppResp<Object> login(@RequestBody @Validated(ValidAccountLogin.class) Account account) {
		return accountService.login(account);
	}

	@RequestMapping("/register")
	@ResponseBody
	public AppResp<Object> register(@RequestBody @Validated(ValidAccountRegister.class) Account account) {
		return accountService.register(account);
	}
}

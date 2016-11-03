package org.changs.campus.api;

import java.util.Set;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.changs.campus.base.AppResp;
import org.changs.campus.base.BaseController;
import org.changs.campus.domain.Account;
import org.changs.campus.service.AccountService;
import org.changs.campus.utils.TextUtils;
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
	public AppResp<Object> login(@Valid @RequestBody(required = true) Account account) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Account>> violations = validator.validate(account);
		if (TextUtils.isEmpty(account.getAccount())) {
			return new AppResp<Object>("账号不能为空");
		}
		if (TextUtils.isEmpty(account.getPasswd())) {
			return new AppResp<Object>("密码不能空");
		}
		return accountService.login(account);
	}

	@RequestMapping("/register")
	@ResponseBody
	public AppResp<Object> register(@RequestBody(required = true) Account account) {
		return accountService.register(account);
	}

	private class LoginAccount extends Account {

	}
}

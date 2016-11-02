package org.changs.campus.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.changs.campus.base.AppResp;
import org.changs.campus.dao.AccountMapper;
import org.changs.campus.dao.UserMapper;
import org.changs.campus.domain.Account;
import org.changs.campus.domain.AccountExample;
import org.changs.campus.domain.AccountExample.Criteria;
import org.changs.campus.domain.User;
import org.changs.campus.service.AccountService;
import org.changs.campus.utils.ListUtils;
import org.changs.campus.utils.TextUtils;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

	private static final Logger log = Logger.getLogger(AccountServiceImpl.class);

	@Resource
	private AccountMapper accountMapper;
	@Resource
	private UserMapper userMapper;

	@Override
	public AppResp<Object> login(Account account) {
		log.debug("login");
		AppResp<Object> validate = validate(account);
		if (validate != null) {
			return validate;
		}

		AccountExample condition = new AccountExample();
		Criteria criteria = condition.createCriteria().andAccountEqualTo(account.getAccount());
		List<Account> list = accountMapper.selectByExample(condition);
		if (ListUtils.isEmpty(list))
			return new AppResp<Object>("账号不存在");

		criteria.andPasswdEqualTo(account.getPasswd());
		list = accountMapper.selectByExample(condition);
		log.debug("list.size() = " + list.size());
		if (ListUtils.isEmpty(list))
			return new AppResp<Object>("密码不正确");

		return new AppResp<Object>(list.get(0));
	}

	@Override
	public AppResp<Object> register(Account account) {
		log.debug("login");
		AppResp<Object> validate = validate(account);
		if (validate != null) {
			return validate;
		}
		AccountExample condition = new AccountExample();
		condition.createCriteria().andAccountEqualTo(account.getAccount());
		List<Account> list = accountMapper.selectByExample(condition);
		if (!ListUtils.isEmpty(list))
			return new AppResp<Object>("账号已存在");

		User user = new User();
		user.setName("新用户");
		int userId = userMapper.insert(user);
		log.debug("userId = " + userId);
		account.setUserid(userId);
		return new AppResp<Object>(account);
	}

	private AppResp<Object> validate(Account account) {
		if (TextUtils.isEmpty(account.getAccount())) {
			return new AppResp<Object>("账号不能为空");
		}
		if (TextUtils.isEmpty(account.getPasswd())) {
			return new AppResp<Object>("密码不能空");
		}
		return null;
	}
}

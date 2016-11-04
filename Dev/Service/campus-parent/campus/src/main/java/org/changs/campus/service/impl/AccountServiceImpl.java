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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public AppResp<Object> register(Account account) {
		log.debug("register");
		AccountExample condition = new AccountExample();
		condition.createCriteria().andAccountEqualTo(account.getAccount());
		List<Account> list = accountMapper.selectByExample(condition);
		if (!ListUtils.isEmpty(list))
			return new AppResp<Object>("账号已存在");

		User user = new User();
		userMapper.insert(user);
		account.setUserid(user.getId());
		accountMapper.insert(account);
		return new AppResp<Object>(user);
	}
}

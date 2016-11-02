package org.changs.campus.service;

import org.changs.campus.base.AppResp;
import org.changs.campus.domain.Account;

public interface AccountService {

	AppResp<Object> login(Account account);

	AppResp<Object> register(Account account);
}

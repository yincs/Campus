package com.changs.kelly.campus.common;

import com.changs.kelly.campus.common.impl.BaseSqDaoImpl;

public class BaseService<T> {
	protected BaseSqlDao<T> sqlDao;

	public BaseService() {
		super();
		sqlDao = new BaseSqDaoImpl<T>();
	}

}

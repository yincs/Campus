package com.changs.kelly.campus.service;

import com.changs.kelly.campus.common.dao.SqDaoImpl;
import com.changs.kelly.campus.common.dao.SqlDao;

public class BaseService<T> {
	protected SqlDao<T> sqlDao;

	public BaseService() {
		super();
		sqlDao = new SqDaoImpl<T>();
	}

}

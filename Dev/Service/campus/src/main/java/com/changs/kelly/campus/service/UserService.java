package com.changs.kelly.campus.service;

import com.changs.kelly.campus.common.BaseService;
import com.changs.kelly.campus.entity.User;

public class UserService extends BaseService<User> {

	public void insert(User user) {
		int insert = sqlDao.insert(user);
		if (insert == 0) {
			System.out.println("insert success");
		} else {
			System.out.println("insert fail");
		}
	}

	public User query(int id) {
		return sqlDao.query(id, User.class);
	}

	public void delete(User user) {
		int delete = sqlDao.delete(user);
		if (delete == 0) {
			System.out.println("delete success");
		} else {
			System.out.println("delete fail");
		}
	}

}

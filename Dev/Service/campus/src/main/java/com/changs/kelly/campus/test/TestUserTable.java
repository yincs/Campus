package com.changs.kelly.campus.test;

import com.changs.kelly.campus.entity.User;
import com.changs.kelly.campus.service.UserService;

import junit.framework.TestCase;

public class TestUserTable extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testInsert() {
		new UserService().insert(new User("kelly", "123456"));
	}

}

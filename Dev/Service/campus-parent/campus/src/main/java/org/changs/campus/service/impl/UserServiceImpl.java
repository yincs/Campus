package org.changs.campus.service.impl;

import javax.annotation.Resource;

import org.changs.campus.base.AppResp;
import org.changs.campus.dao.UserMapper;
import org.changs.campus.domain.User;
import org.changs.campus.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	
	@Override
	public AppResp<Object> selectOne(int id) {
		 User user = userMapper.selectByPrimaryKey(id);
		 if (user == null) {
			return new AppResp<Object>("用户不存在");
		}
		 return new AppResp<Object>(user);
	}

	@Override
	public AppResp<Object> updateOne(User user) {
		userMapper.updateByPrimaryKeySelective(user);
		return new AppResp<Object>(null);
	}

}

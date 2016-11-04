package org.changs.campus.service;

import org.changs.campus.base.AppResp;
import org.changs.campus.domain.User;

public interface UserService {

	public AppResp<Object> selectOne(int id);
	
	public AppResp<Object> updateOne(User user); 
}

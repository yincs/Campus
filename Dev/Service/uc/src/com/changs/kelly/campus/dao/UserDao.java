package com.changs.kelly.campus.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.changs.kelly.campus.entity.UserInfo;

public class UserDao extends Dao<UserInfo> {

	public UserDao() {
	}

	@Override
	public boolean insert(UserInfo info) {
		String sql = "insert into user_info "
				+ "(user_id,user_name,user_remark,user_sex,user_brithday,user_shool_current,user_friends,user_friends_applying) "
				+ "value (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = mConn.prepareStatement(sql);
			ps.setString(1, info.getUserId());
			ps.setString(2, info.getUserName());
			ps.setString(3, info.getUserRemark());
			ps.setInt(4, 	info.getUserSex());
			ps.setString(5, info.getUserBrithday());
			ps.setString(6, info.getUserShoolCurrent());
			ps.setString(7, info.getUserFridens());
			ps.setString(8, info.getUserFriendsApplying());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean delete(UserInfo info) {
		return false;
	}

	@Override
	public boolean delete(int id) {
		return false;
	}

	@Override
	public boolean update(UserInfo info) {
		return false;
	}

	@Override
	public UserInfo query(int id) {
		return null;
	}

}

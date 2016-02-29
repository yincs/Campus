package com.changs.kelly.campus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.changs.kelly.campus.entity.UserInfo;

public class UserDao extends Dao<UserInfo> {
	public static final String TABLE_NAME = "userinfo";

	public UserDao() {
		super();
	}

	@Override
	public boolean insert(UserInfo info) {
		final String sql = "insert into " + TABLE_NAME + " "
				+ "(user_id,user_name,user_remark,user_sex,user_brithday,user_shool_current,user_friends,user_friends_applying) "
				+ "value (?,?,?,?,?,?,?,?)";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
			    PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, info.getUserId());
				ps.setString(2, info.getUserName());
				ps.setString(3, info.getUserRemark());
				ps.setInt(4, info.getUserSex());
				ps.setString(5, info.getUserBrithday());
				ps.setString(6, info.getUserShoolCurrent());
				ps.setString(7, info.getUserFridens());
				ps.setString(8, info.getUserFriendsApplying());	
				return ps;
			}
		});
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
		String sql = "select * from " + TABLE_NAME + " " + "where id=" + id;
		return null;
	}

	public UserInfo query(String userId) {
		String sql = "select * from " + TABLE_NAME + " " + "where user_id=" + userId;
		return null;
	}
	
	PreparedStatementCreator creator = new PreparedStatementCreator(){
        @Override
        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
    		String sql = "insert into " + TABLE_NAME + " "
    				+ "(user_id,user_name,user_remark,user_sex,user_brithday,user_shool_current,user_friends,user_friends_applying) "
    				+ "value (?,?,?,?,?,?,?,?)";
        	connection.prepareStatement(sql);
//			ps.setString(1, info.getUserId());
//			ps.setString(2, info.getUserName());
//			ps.setString(3, info.getUserRemark());
//			ps.setInt(4, info.getUserSex());
//			ps.setString(5, info.getUserBrithday());
//			ps.setString(6, info.getUserShoolCurrent());
//			ps.setString(7, info.getUserFridens());
//			ps.setString(8, info.getUserFriendsApplying());
            return null;
        }
    };
}

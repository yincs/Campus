package com.changs.kelly.campus.entity;

public class UserInfo {
	private int 	id;
	
	private String 	userId;
	
	private String 	userName;
	
	private String 	userRemark;
	
	private int 	userSex = 3;
	
	private String 	userBrithday;
	
	private String 	userShoolCurrent;
	
	private String 	userFridens;
	
	private String 	userFriendsApplying;
	

	public UserInfo() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserRemark() {
		return userRemark;
	}

	public void setUserRemark(String userRemark) {
		this.userRemark = userRemark;
	}

	public int getUserSex() {
		return userSex;
	}

	public void setUserSex(int userSex) {
		this.userSex = userSex;
	}

	public String getUserBrithday() {
		return userBrithday;
	}

	public void setUserBrithday(String userBrithday) {
		this.userBrithday = userBrithday;
	}

	public String getUserShoolCurrent() {
		return userShoolCurrent;
	}

	public void setUserShoolCurrent(String userShoolCurrent) {
		this.userShoolCurrent = userShoolCurrent;
	}

	public String getUserFridens() {
		return userFridens;
	}

	public void setUserFridens(String userFridens) {
		this.userFridens = userFridens;
	}

	public String getUserFriendsApplying() {
		return userFriendsApplying;
	}

	public void setUserFriendsApplying(String userFriendsApplying) {
		this.userFriendsApplying = userFriendsApplying;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", userId=" + userId + ", userName=" + userName + ", userRemark=" + userRemark
				+ ", userSex=" + userSex + ", userBrithday=" + userBrithday + ", userShoolCurrent=" + userShoolCurrent
				+ ", userFridens=" + userFridens + ", userFriendsApplying=" + userFriendsApplying + "]";
	}
}

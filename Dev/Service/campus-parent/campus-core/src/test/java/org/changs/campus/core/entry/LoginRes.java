package org.changs.campus.core.entry;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class LoginRes {
	@NotNull(message = "用户名不能为空")
	private String account;

	@NotNull(message = "密码不能为空")
	@Pattern(regexp = "[0-9a-zA-Z_]{6,30}", message = "密码必须是6-30个字母数字或者下划线")
	private String passwd;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}

package com.changs.kelly.campus.entity;

/*
* 在此标记不生成json对象的属性，这里我标记了两个属性一个hibernateLazyInitializer属性，为什么要标记这个 
* 属性参考前面的博文，一个password属性，出于安全这个当然不能转换成json对象了，毕竟json是在前台调用的， 
* 如果你想转换的时候忽略某个属性，可以在后面继续加上 
*/
//@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "password"})  
public class UserBean {

	private String password;
	private String name;

	public UserBean() {
		super();
	}

	public UserBean(String password, String name) {
		super();
		this.password = password;
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

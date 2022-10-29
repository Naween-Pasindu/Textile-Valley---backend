package com.textileValley.authentication.Response;

public class UserInfo {
	
//	-------------1.14.22-------------------
	private int userName;
	private Object roles;
	
	public int getUserName() {
		return userName;
	}
	public void setUserName(int userName) {
		this.userName = userName;
	}
	public Object getRoles() {
		return roles;
	}
	public void setRoles(Object roles) {
		this.roles = roles;
	}

}

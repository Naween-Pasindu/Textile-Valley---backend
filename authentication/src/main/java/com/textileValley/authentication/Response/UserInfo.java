package com.textileValley.authentication.Response;

public class UserInfo {
	
//	-------------1.14.22-------------------
	private String userName;
	private Object roles;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Object getRoles() {
		return roles;
	}
	public void setRoles(Object roles) {
		this.roles = roles;
	}

}

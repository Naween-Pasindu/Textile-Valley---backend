package com.textileValley.authentication.model;

public class AuthenticationRequest {

	
	private String email;

	private String username;
	
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public AuthenticationRequest() {

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String userName) {
		this.email = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

package com.textileValley.item.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class login {

	@Id
	@GeneratedValue
	private int id;
	private int userId;

	private int roleId;

	private String emailEncrypted;

	private String emailHashed;

	private String passwordhashed;

	private String userName;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getId() {
		return userId;
	}

	public void setId(int userId) {
		this.userId = userId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getEmailEncrypted() {
		return emailEncrypted;
	}

	public void setEmailEncrypted(String emailEncrypted) {
		this.emailEncrypted = emailEncrypted;
	}

	public String getEmailHashed() {
		return emailHashed;
	}

	public void setEmailHashed(String emailHashed) {
		this.emailHashed = emailHashed;
	}

	public String getPasswordhashed() {
		return passwordhashed;
	}

	public void setPasswordhashed(String passwordhashed) {
		this.passwordhashed = passwordhashed;
	}

	public login() {

	}
};

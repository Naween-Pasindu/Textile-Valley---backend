package com.textileValley.authentication.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name = "User")
public class Registered_Customer {

	@Id
	@GeneratedValue
	private int id;
	private String userName;
	private String password;
	private String accountState;

	public Registered_Customer() {

	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getuserName() {
		return userName;
	}
	public void setuserName(String userName) {
		this.userName = userName;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}

	public String getaccountState() {
		return accountState;
	}
	public void setaccountState(String accountState) {
		this.accountState = accountState;
	}

};

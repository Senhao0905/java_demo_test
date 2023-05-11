package com.example.java_demo_test.vo;

import com.example.java_demo_test.entity.Login;

public class LoginActivationResponse {

	private String message;
	
	private String account;

	private Login login;
	
	
	public LoginActivationResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginActivationResponse(Login login) {
		super();
		this.login = login;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public LoginActivationResponse(String message, String account) {
		super();
		this.message = message;
		this.account = account;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public LoginActivationResponse(String message) {
		super();
		this.message = message;
	}

	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}

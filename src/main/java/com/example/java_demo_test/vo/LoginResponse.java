package com.example.java_demo_test.vo;

import com.example.java_demo_test.entity.Login;

public class LoginResponse {

	private String message;

	private Login login;

	public LoginResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginResponse(Login login) {
		super();
		this.login = login;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public LoginResponse(String message) {
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

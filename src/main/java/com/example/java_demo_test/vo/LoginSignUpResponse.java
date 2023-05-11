package com.example.java_demo_test.vo;

import com.example.java_demo_test.entity.Login;

public class LoginSignUpResponse {

	private String message;
	
	private Login login;

	public LoginSignUpResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginSignUpResponse(String message) {
		super();
		this.message = message;
	}

	public LoginSignUpResponse(String message, Login login) {
		super();
		this.message = message;
		this.login = login;
	}

	public LoginSignUpResponse(Login login) {
		super();
		this.login = login;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}

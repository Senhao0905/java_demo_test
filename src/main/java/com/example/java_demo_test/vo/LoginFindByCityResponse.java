package com.example.java_demo_test.vo;

import java.util.List;

import com.example.java_demo_test.entity.Login;

public class LoginFindByCityResponse {

	private String message;
	
	private List<Login> login;

	public LoginFindByCityResponse() {
		
	}

	public LoginFindByCityResponse(String message) {
		super();
		this.message = message;
	}

	public LoginFindByCityResponse(String message, List<Login> login) {
		super();
		this.message = message;
		this.login = login;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Login> getLogin() {
		return login;
	}

	public void setLogin(List<Login> login) {
		this.login = login;
	}
	
	
}

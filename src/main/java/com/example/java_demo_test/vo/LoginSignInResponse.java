package com.example.java_demo_test.vo;



public class LoginSignInResponse {

	private String message;
	
	private String account;

	public LoginSignInResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginSignInResponse(String message, String account) {
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

	public LoginSignInResponse(String message) {
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

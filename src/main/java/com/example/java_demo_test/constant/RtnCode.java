package com.example.java_demo_test.constant;

public enum RtnCode {

	SUCCESSFUL("200","Successful !"),
	CANNOT_EMPTY("400","Account or Password cannot is empty!!"),
	DATA_ERROR("400","Account or Password cannot is error!!"),
	NOT_FOUND("404","Not found");
	
	private String code;
	
	private String message;

	private RtnCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}

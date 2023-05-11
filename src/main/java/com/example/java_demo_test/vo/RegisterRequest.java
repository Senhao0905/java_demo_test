package com.example.java_demo_test.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterRequest {

	@JsonProperty("account")
	String account;
	@JsonProperty("pwd")
	String pwd;
	@JsonProperty("verify_Code")
	int verifyCode;

	public int getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(int verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}

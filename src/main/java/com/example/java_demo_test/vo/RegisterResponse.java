package com.example.java_demo_test.vo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterResponse {

	@JsonProperty("sessionn_id")
	private String sessionnId;
	
	@JsonProperty("verify_code")
	private int verifyCode;
	
	@JsonProperty("reg_time")
	private LocalDateTime regTime;
	
	private String meseage;

	public RegisterResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegisterResponse(String meseage) {
		super();
		this.meseage = meseage;
	}

	public RegisterResponse(LocalDateTime regTime, String meseage) {
		super();
		this.regTime = regTime;
		this.meseage = meseage;
	}

	public String getSessionnId() {
		return sessionnId;
	}

	public void setSessionnId(String sessionnId) {
		this.sessionnId = sessionnId;
	}

	public int getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(int verifyCode) {
		this.verifyCode = verifyCode;
	}

	public LocalDateTime getRegTime() {
		return regTime;
	}

	public void setRegTime(LocalDateTime regTime) {
		this.regTime = regTime;
	}

	public String getMeseage() {
		return meseage;
	}

	public void setMeseage(String meseage) {
		this.meseage = meseage;
	}
	
	
}

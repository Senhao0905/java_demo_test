package com.example.java_demo_test.vo;

import java.util.List;

import com.example.java_demo_test.entity.PersonInfo;

public class PersonInfoResponse {
	
	private String message ;
	
	private List<PersonInfo> resPersonInfo;		

	public PersonInfoResponse() {
		
	}

	public PersonInfoResponse(String message) {
		
		this.message = message;
	}

	public PersonInfoResponse(String message, List<PersonInfo> personInfos) {
		
		this.message = message;
		this.resPersonInfo = personInfos;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<PersonInfo> getPersonInfos() {
		return resPersonInfo;
	}

	public void setPersonInfos(List<PersonInfo> personInfos) {
		this.resPersonInfo = personInfos;
	}
	
	

}

package com.example.java_demo_test.vo;

import java.util.List;

import com.example.java_demo_test.entity.PersonInfo;

public class GetPersonInfoResponse {
	
	private List<PersonInfo> personInfos;

	private PersonInfo personInfo;

	private String message;

	public GetPersonInfoResponse() {

	}

	public GetPersonInfoResponse(String message) {
	
		this.message = message;
	}

	public GetPersonInfoResponse(PersonInfo personInfo, String message) {

		this.personInfo = personInfo;
		this.message = message;
	}

	public List<PersonInfo> getPersonInfos() {
		return personInfos;
	}

	public GetPersonInfoResponse(List<PersonInfo> personInfos, String message) {
		super();
		this.personInfos = personInfos;
		this.message = message;
	}

	public void setPersonInfos(List<PersonInfo> personInfos) {
		this.personInfos = personInfos;
	}

	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

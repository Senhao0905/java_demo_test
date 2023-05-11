package com.example.java_demo_test.vo;

import com.example.java_demo_test.entity.Login;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginRequest {

	@JsonProperty("login")
	private Login login;

	@JsonProperty("account")
	private String account;

	@JsonProperty("age")
	private int age;

	@JsonProperty("name")
	private String name;

	@JsonProperty("pwd")
	private String pwd;

	@JsonProperty("city")
	private String city;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

}

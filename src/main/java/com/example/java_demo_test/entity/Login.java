package com.example.java_demo_test.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "login")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Login {

	@Id
	@Column(name = "account")
	private String account;

	@Column(name = "password")
	private String pwd;

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private int age;

	@Column(name = "city")
	private String city;

	/*
	 * Date ==> new Date(); localDateTime ==> new localDateTime.now()
	 */
	@Column(name = "register_time")
	private LocalDateTime registerTime = LocalDateTime.now();

	@Column(name = "active")
	private boolean isActive;

	public Login() {

	}

	public Login(String account, String name, int age, String city, LocalDateTime registerTime, boolean isActive) {
		super();
		this.account = account;
		this.name = name;
		this.age = age;
		this.city = city;
		this.registerTime = registerTime;
		this.isActive = isActive;
	}

	public Login(String account, String pwd, String name, int age, String city) {
		super();
		this.account = account;
		this.pwd = pwd;
		this.name = name;
		this.age = age;
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

	public void setPwd(String password) {
		this.pwd = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public LocalDateTime getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(LocalDateTime registerTime) {
		this.registerTime = registerTime;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}

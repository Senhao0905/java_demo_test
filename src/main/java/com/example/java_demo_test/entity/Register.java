package com.example.java_demo_test.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "register")
public class Register {
	
	@Id   //mysql裡面的主鍵 PK(Primary Key)
	@Column(name = "account")
	private String account;
    
    @Column(name = "pwd")  //將類別中的屬性跟Table中的欄位作關聯
	private String pwd;

	@Column(name = "reg_time")
	private LocalDateTime regTime = LocalDateTime.now();
	
	@Column(name="active")
	private boolean isActive;

	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Register(String account, String pwd) {
		super();
		this.account = account;
		this.pwd = pwd;
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

	public LocalDateTime getRegTime() {
		return regTime;
	}

	public void setRegTime(LocalDateTime regTime) {
		this.regTime = regTime;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	


}

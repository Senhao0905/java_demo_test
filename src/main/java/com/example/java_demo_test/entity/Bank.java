package com.example.java_demo_test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity    //交由spring 作託管
@Table(name = "bank")  //告訴spring 此類別要與資料庫哪個Table作關聯
public class Bank {
	
    @Id   //mysql裡面的主鍵 PK(Primary Key)
	@Column(name = "account")
	private String account;
    
    @Column(name = "amount")  //將類別中的屬性跟Table中的欄位作關聯
	private int amount;

	@Column(name = "password")
	private String pwd;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Bank() {
		
	}

	public Bank(String account,String pwd,int amount) {
		super();
		this.account = account;
		this.amount = amount;
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

}

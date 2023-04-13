package com.example.java_demo_test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity    //���spring �@�U��
@Table(name = "bank")  //�i�Dspring �����O�n�P��Ʈw����Table�@���p
public class Bank {
	
    @Id   //mysql�̭����D�� PK(Primary Key)
	@Column(name = "account")
	private String account;
    
    @Column(name = "amount")  //�N���O�����ݩʸ�Table�������@���p
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

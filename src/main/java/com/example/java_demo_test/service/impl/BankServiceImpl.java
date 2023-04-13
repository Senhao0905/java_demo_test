package com.example.java_demo_test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.java_demo_test.entity.Bank;
import com.example.java_demo_test.repository.BankDao;
import com.example.java_demo_test.service.ifs.BankService;

@Service
public class BankServiceImpl implements BankService{
	
	private String checkAccount = "[\\w&&[^_]]{3,8}";
	private String checkPwd = "[\\w[.~!@#$%]]{8,16}";
	
	@Autowired
	private BankDao bankDao;
	

	@Override
	public void addInfo(Bank bank) {
		//帳號格式檢驗
		checkAccount(bank);							
		//密碼格式檢驗	
		checkPwd(bank);	
		//餘額格式檢驗
		if(bank.getAmount() < 0) {
			System.out.println("餘額不可小於0");
			return;
		}
		
		bankDao.save(bank);
						
	}
	
	private void checkAccount(Bank bank) {
		if(bank == null || bank.getAccount() == null) {
			System.out.println("不可為空");
			return;
		}
		if(!bank.getAccount().matches(checkAccount)) {		
			System.out.println("帳號格式錯誤");
			return;
		}
	}
	
	private void checkPwd(Bank bank) {
		if(bank.getPwd() == null) {
			System.out.println("密碼不可為空");
			return;
		}
		if(!bank.getPwd().matches(checkPwd)) {		
			System.out.println("密碼格式錯誤");
			return;
		}	
	}
	
	

}

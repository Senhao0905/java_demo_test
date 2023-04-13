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
		//�b���榡����
		checkAccount(bank);							
		//�K�X�榡����	
		checkPwd(bank);	
		//�l�B�榡����
		if(bank.getAmount() < 0) {
			System.out.println("�l�B���i�p��0");
			return;
		}
		
		bankDao.save(bank);
						
	}
	
	private void checkAccount(Bank bank) {
		if(bank == null || bank.getAccount() == null) {
			System.out.println("���i����");
			return;
		}
		if(!bank.getAccount().matches(checkAccount)) {		
			System.out.println("�b���榡���~");
			return;
		}
	}
	
	private void checkPwd(Bank bank) {
		if(bank.getPwd() == null) {
			System.out.println("�K�X���i����");
			return;
		}
		if(!bank.getPwd().matches(checkPwd)) {		
			System.out.println("�K�X�榡���~");
			return;
		}	
	}
	
	

}

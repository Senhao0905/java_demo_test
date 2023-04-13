package com.example.java_demo_test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.java_demo_test.entity.Bank;
import com.example.java_demo_test.repository.BankDao;

@SpringBootTest(classes = JavaDemoTestApplication.class)
public class BankTest {
	
	@Autowired
	private BankDao bankDao;
    
	@Test
	public void addBankInfo() {
		Bank bank = new Bank("a01","123456",10000);
		//新增資料到bank 這個Table
		bankDao.save(bank);
		
		
	}

}

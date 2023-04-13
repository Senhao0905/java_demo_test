package com.example.java_demo_test;

import static org.mockito.ArgumentMatchers.nullable;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.java_demo_test.entity.Bank;
import com.example.java_demo_test.repository.BankDao;
import com.example.java_demo_test.service.ifs.BankService;

@SpringBootTest(classes = JavaDemoTestApplication.class)
public class BankTest {
	
	@Autowired
	private BankDao bankDao;
	
	@Autowired
	private BankService bankService;
    
	@Test
	public void addBankInfo() {
		Bank bank = new Bank("a01","123456",10000);
		//新增資料到bank 這個Table
		bankDao.save(bank);
			
	}
	
	@Test
	public void bankServiceTest() {
		Bank bank = new Bank("a1.23","123.5678",10000);
		//新增資料到bank 這個Table
		bankService.addInfo(bank);
		
		
				
	}

}

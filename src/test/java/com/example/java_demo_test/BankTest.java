package com.example.java_demo_test;

import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.inOrder;

import java.util.Scanner;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.java_demo_test.entity.Bank;
import com.example.java_demo_test.repository.BankDao;
import com.example.java_demo_test.service.ifs.BankService;
import com.example.java_demo_test.vo.BankResponse;

@SpringBootTest(classes = JavaDemoTestApplication.class)
public class BankTest {
	
	@Autowired
	private BankDao bankDao;
	
	@Autowired
	private BankService bankService;
    
	@Test
	public void addBankInfo() {
		Bank bank = new Bank("a01","123456",10000);
		//�s�W��ƨ�bank �o��Table
		bankDao.save(bank);
		
			
	}
	
	@Test
	public void addInfoTest() {
		Bank bank = new Bank("AA999","AA123456@",2000);
		//�s�W��ƨ�bank �o��Table
		bankService.addInfo(bank);
												
	}
	@Test
	public void getAmountByIdTest() {		
		Bank bank  = bankService.getAmountById("a1243");
//		Assert.isTrue(bank.getAccount() != null, "�d�L���");
		System.out.println("�b��:"+bank.getAccount()+"�l�B:"+bank.getAmount());
	}
	
	@Test
	public void depositTest() {			
		Bank oldBank = bankDao.save(new Bank("AA999","AA123456@",2000));
		Bank newBank = new Bank("AA999","AA123456@",3000);
		BankResponse response = bankService.deposit(newBank);
		Bank resBank = response.getBank();
		Assert.isTrue(resBank.getAmount() == (oldBank.getAmount()+ newBank.getAmount()),"�s�ڥ���");
		Assert.isTrue(response.getMessage().equals("�s�ڦ��\"),"�s�ڥ���");
		bankDao.delete(resBank);
	}
	@Test
	public void withdrawTest() {
		Bank oldBank = bankDao.save(new Bank("AA999","AA123456@",2000));
		Bank newBank = new Bank("AA999","AA123456@",1000);
		BankResponse response = bankService.withdraw(newBank);
		Bank resBank = response.getBank();
		Assert.isTrue(resBank.getAmount() == (oldBank.getAmount()- newBank.getAmount()),"���ڥ���");
		Assert.isTrue(response.getMessage().equals("���ڦ��\"),"���ڥ���");
		bankDao.delete(resBank);
		
	}
	
	
	

}

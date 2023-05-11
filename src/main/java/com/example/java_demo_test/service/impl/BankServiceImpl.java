package com.example.java_demo_test.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.java_demo_test.entity.Bank;
import com.example.java_demo_test.repository.BankDao;
import com.example.java_demo_test.service.ifs.BankService;
import com.example.java_demo_test.vo.BankResponse;

@Service
public class BankServiceImpl implements BankService {

	private String checkAccount = "[\\w&&[^_]]{3,8}";
	private String checkPwd = "[\\w[.~!@#$%]+]{8,16}";

	@Autowired
	private BankDao bankDao;

	@Override
	public void addInfo(Bank bank) {
		// �b���榡����
		checkAccount(bank);
		// �K�X�榡����
		checkPwd(bank);
		// �l�B�榡����
		if (bank.getAmount() < 0) {
			System.out.println("�l�B���i�p��0");
			return;
		}

		bankDao.save(bank);

	}

	void checkAccount(Bank bank) {
		if (bank == null || bank.getAccount() == null) {
			System.out.println("���i����");
			return;
		}
		if (!bank.getAccount().matches(checkAccount)) {
			System.out.println("�b���榡���~");
			return;
		}
	}

	private void checkPwd(Bank bank) {
		if (bank.getPwd() == null) {
			System.out.println("�K�X���i����");
			return;
		}
		if (!bank.getPwd().matches(checkPwd)) {
			System.out.println("�K�X�榡���~");
			return;
		}
	}

	@Override
	public Bank getAmountById(String id) {
		if (!StringUtils.hasText(id)) {
			return new Bank();
		}
		// Optional ��²�g�k
		Optional<Bank> op = bankDao.findById(id);
		// �ǲμg�k
//		if(!op.isPresent()) {
//			return new Bank();
//		}
//		return op.get();

		// orElse �Y��H��null�h����^��()�������e
		return op.orElse(new Bank());
	}

	@Override
	public BankResponse deposit(Bank bank) {
		if (bank == null || !StringUtils.hasText(bank.getAccount()) || !StringUtils.hasText(bank.getPwd())
				|| bank.getAmount() <= 0) {
			return new BankResponse(new Bank(),"�b���αK�X���~");
		}
		
//		Optional<Bank> op = bankDao.findById(bank.getAccount());
//		if(!op.isPresent()) {
//			return new Bank();
//		}
//		Bank resBank = op.get();
		Bank resBank = bankDao.findByAccountAndPwd(bank.getAccount(), bank.getPwd());
		if (resBank == null) {
			return new BankResponse(new Bank(),"��Ƥ��s�b");
		}
		
		// ��l�B + �s���B
		int amount = resBank.getAmount();

		// ��l�B + �s���B
		amount += bank.getAmount();

		// �s�l�B ��s�ܸ�Ʈw
		resBank.setAmount(amount);

		// �^�ǧ�s���Ʈw
		return new BankResponse(bankDao.save(resBank),"�s�ڦ��\");

	}

	@Override
	public BankResponse withdraw(Bank bank) {
		if (bank == null || !StringUtils.hasText(bank.getAccount()) || !StringUtils.hasText(bank.getPwd())
				|| bank.getAmount() <= 0) {
			return new BankResponse(new Bank(),"�b���αK�X���~");
		}
		
		Bank resBank = bankDao.findByAccountAndPwd(bank.getAccount(), bank.getPwd());
		if (resBank == null) {
			return new BankResponse(new Bank(),"��Ƥ��s�b");
		}
		
		int amount = resBank.getAmount();
		
		//�l�B�j�󴣴��B
		if(amount < bank.getAmount()) {
			return new BankResponse(new Bank(),"�l�B����");
		}

		// ��l�B - �����B
		amount -= bank.getAmount();

		// �s�l�B ��s�ܸ�Ʈw
		resBank.setAmount(amount);

		// �^�ǧ�s���Ʈw
		return new BankResponse(bankDao.save(resBank),"���ڦ��\");
				
			
	}

}

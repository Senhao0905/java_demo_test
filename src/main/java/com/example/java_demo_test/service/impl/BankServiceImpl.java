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
		// 帳號格式檢驗
		checkAccount(bank);
		// 密碼格式檢驗
		checkPwd(bank);
		// 餘額格式檢驗
		if (bank.getAmount() < 0) {
			System.out.println("餘額不可小於0");
			return;
		}

		bankDao.save(bank);

	}

	void checkAccount(Bank bank) {
		if (bank == null || bank.getAccount() == null) {
			System.out.println("不可為空");
			return;
		}
		if (!bank.getAccount().matches(checkAccount)) {
			System.out.println("帳號格式錯誤");
			return;
		}
	}

	private void checkPwd(Bank bank) {
		if (bank.getPwd() == null) {
			System.out.println("密碼不可為空");
			return;
		}
		if (!bank.getPwd().matches(checkPwd)) {
			System.out.println("密碼格式錯誤");
			return;
		}
	}

	@Override
	public Bank getAmountById(String id) {
		if (!StringUtils.hasText(id)) {
			return new Bank();
		}
		// Optional 精簡寫法
		Optional<Bank> op = bankDao.findById(id);
		// 傳統寫法
//		if(!op.isPresent()) {
//			return new Bank();
//		}
//		return op.get();

		// orElse 若對象為null則執行回傳()內的內容
		return op.orElse(new Bank());
	}

	@Override
	public BankResponse deposit(Bank bank) {
		if (bank == null || !StringUtils.hasText(bank.getAccount()) || !StringUtils.hasText(bank.getPwd())
				|| bank.getAmount() <= 0) {
			return new BankResponse(new Bank(),"帳號或密碼錯誤");
		}
		
//		Optional<Bank> op = bankDao.findById(bank.getAccount());
//		if(!op.isPresent()) {
//			return new Bank();
//		}
//		Bank resBank = op.get();
		Bank resBank = bankDao.findByAccountAndPwd(bank.getAccount(), bank.getPwd());
		if (resBank == null) {
			return new BankResponse(new Bank(),"資料不存在");
		}
		
		// 原餘額 + 存款額
		int amount = resBank.getAmount();

		// 原餘額 + 存款額
		amount += bank.getAmount();

		// 新餘額 更新至資料庫
		resBank.setAmount(amount);

		// 回傳更新後資料庫
		return new BankResponse(bankDao.save(resBank),"存款成功");

	}

	@Override
	public BankResponse withdraw(Bank bank) {
		if (bank == null || !StringUtils.hasText(bank.getAccount()) || !StringUtils.hasText(bank.getPwd())
				|| bank.getAmount() <= 0) {
			return new BankResponse(new Bank(),"帳號或密碼錯誤");
		}
		
		Bank resBank = bankDao.findByAccountAndPwd(bank.getAccount(), bank.getPwd());
		if (resBank == null) {
			return new BankResponse(new Bank(),"資料不存在");
		}
		
		int amount = resBank.getAmount();
		
		//餘額大於提款額
		if(amount < bank.getAmount()) {
			return new BankResponse(new Bank(),"餘額不足");
		}

		// 原餘額 - 提款額
		amount -= bank.getAmount();

		// 新餘額 更新至資料庫
		resBank.setAmount(amount);

		// 回傳更新後資料庫
		return new BankResponse(bankDao.save(resBank),"提款成功");
				
			
	}

}

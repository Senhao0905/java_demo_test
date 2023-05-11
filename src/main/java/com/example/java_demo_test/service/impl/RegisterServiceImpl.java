package com.example.java_demo_test.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.java_demo_test.entity.Register;
import com.example.java_demo_test.repository.RegisterDao;
import com.example.java_demo_test.service.ifs.RegisterService;
import com.example.java_demo_test.vo.RegisterResponse;



@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterDao registerDao;

	@Override
	public RegisterResponse register(String account, String pwd) {

		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new RegisterResponse("Can not empty");
		}

		if (registerDao.existsById(account)) {
			return new RegisterResponse("Account Exists");
		}
		Register register = new Register(account, pwd);
		registerDao.save(register);
		return new RegisterResponse("ok");
	}

	@Override
	public RegisterResponse active(String account, String pwd) {
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new RegisterResponse("Can not empty");
		}
		Register res = registerDao.findByAccountAndPwd(account, pwd);
		if (res == null) {
			return new RegisterResponse("acccount or password Error ");
		}
		res.setActive(true);

		registerDao.save(res);

		return new RegisterResponse("ok");
	}

	@Override
	public RegisterResponse login(String account, String pwd) {
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new RegisterResponse("Can not empty");
		}
		Register res = registerDao.findByAccountAndPwdAndIsActive(account, pwd,true);
		if (res == null) {
			return new RegisterResponse("acccount or password Error or not active");
		}		
		
		return new RegisterResponse("welcome");
	}

	@Override
	public RegisterResponse getRegTime(String account, String pwd) {
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new RegisterResponse("Can not empty");
		}
		Register res = registerDao.findByAccountAndPwdAndIsActive(account, pwd,true);
		if (res == null) {
			return new RegisterResponse("acccount or password Error");
		}		
		
		return new RegisterResponse(res.getRegTime(),"welcome");
	}

}

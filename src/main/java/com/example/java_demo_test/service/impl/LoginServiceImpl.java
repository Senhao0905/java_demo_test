package com.example.java_demo_test.service.impl;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.util.CollectionUtils;

import com.example.java_demo_test.constant.RtnCode;
import com.example.java_demo_test.entity.Login;
import com.example.java_demo_test.repository.LoginDao;
import com.example.java_demo_test.service.ifs.LoginService;
import com.example.java_demo_test.vo.LoginActivationResponse;
import com.example.java_demo_test.vo.LoginFindByCityResponse;

import com.example.java_demo_test.vo.LoginSignInResponse;
import com.example.java_demo_test.vo.LoginSignUpResponse;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;

	private String checkAccount = "[\\w&&[^_]]{3,8}";

	private String checkPwd = "(?=.*[.~!@#$%])[\\w[.~!@#$%]]{8,12}";
	
	private String checkPwd2 = "^(?=.*[\\p{punct}])[\\s]{8,12}$";
	/*
	 * \p ��ܤǰt���r����ƬY�دS��
	 * Punct ��ܼ��I�Ÿ�
	 */
	
	
	

	@Override
	public LoginSignUpResponse loginSignUp(String account,String pwd,String name,int age,String city) {
	
		// �b�� �K�X �W�٤��o���ťթ�null
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)
				|| !StringUtils.hasText(name)) {

			return new LoginSignUpResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}

		// �b���榡����
		if (!account.matches(checkAccount)) {
			return new LoginSignUpResponse(RtnCode.DATA_ERROR.getMessage());
		}

		// �K�X�榡����
		if (!pwd.matches(checkPwd)) {
			return new LoginSignUpResponse(RtnCode.DATA_ERROR.getMessage());
		}

		// �b���ݩ|���Q���U
		if (loginDao.existsById(account)) {
			return new LoginSignUpResponse(RtnCode.DATA_ERROR.getMessage());
		}
		
		Login res = new Login(account, pwd, name, age, city);
		loginDao.save(res);
		return new LoginSignUpResponse(RtnCode.SUCCESSFUL.getMessage(), res);
	}

	@Override
	public LoginActivationResponse loginActivation(String account, String pwd) {
		// �T�{��J�����ũ�null
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {

			return new LoginActivationResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}
		// �ˬd�b���K�X
		Login response = loginDao.findByAccountAndPwd(account, pwd);

		if(response == null) {
			return new LoginActivationResponse(RtnCode.DATA_ERROR.getMessage());
		}

		if(response.isActive()) {
			return new LoginActivationResponse(RtnCode.DATA_ERROR.getMessage());
		}

		response.setActive(true);

		loginDao.save(response);

		return new LoginActivationResponse(RtnCode.SUCCESSFUL.getMessage(), account);
	}

	@Override
	public LoginSignInResponse loginSignIn(String account, String pwd) {
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new LoginSignInResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}

		// �ˬd�b���K�X
		Login response = loginDao.findByAccountAndPwd(account, pwd);

		if(response == null) {
			return new LoginSignInResponse(RtnCode.DATA_ERROR.getMessage());
		}
		
		if (!response.isActive()) {
			return new LoginSignInResponse(RtnCode.DATA_ERROR.getMessage());
		}

		return new LoginSignInResponse(RtnCode.SUCCESSFUL.getMessage(), account);

	}

	@Override
	public LoginFindByCityResponse loginFindByCity(String city) {
		if (!StringUtils.hasText(city)) {
			return new LoginFindByCityResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}
		List<Login> res = loginDao.findByCityContainingOrderByAgeDesc(city);
		
		if (CollectionUtils.isEmpty(res)) {
			return new LoginFindByCityResponse(RtnCode.NOT_FOUND.getMessage());
		}
		for(Login item : res) {
			item.setPwd(null);
		}
	
		return new LoginFindByCityResponse(RtnCode.SUCCESSFUL.getMessage(), res);

	}

	

	
}



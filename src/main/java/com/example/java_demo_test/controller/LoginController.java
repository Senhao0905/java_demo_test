package com.example.java_demo_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.java_demo_test.service.ifs.LoginService;
import com.example.java_demo_test.vo.LoginActivationResponse;
import com.example.java_demo_test.vo.LoginFindByCityResponse;
import com.example.java_demo_test.vo.LoginRequest;
import com.example.java_demo_test.vo.LoginSignInResponse;
import com.example.java_demo_test.vo.LoginSignUpResponse;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@PostMapping(value = "login_sign_up")
	public LoginSignUpResponse loginSignUp(@RequestBody LoginRequest request) {
		return loginService.loginSignUp(request.getAccount(),request.getPwd(),request.getName(),request.getAge(),request.getCity());
	}
	
	@PostMapping(value = "login_activation")
	public LoginActivationResponse loginActivation(@RequestBody LoginRequest request) {
		return loginService.loginActivation(request.getAccount(), request.getPwd());
	}
	
	@PostMapping(value = "login_sign_in")
	public LoginSignInResponse loginSignIn(@RequestBody LoginRequest request) {
		return loginService.loginSignIn(request.getAccount(), request.getPwd());
	}
	@PostMapping(value = "login_find_by_city")
	public LoginFindByCityResponse loginFindByCity(@RequestBody LoginRequest request) {
		return loginService.loginFindByCity(request.getCity());
	}
}

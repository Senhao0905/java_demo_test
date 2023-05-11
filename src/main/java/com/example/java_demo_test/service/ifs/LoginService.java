package com.example.java_demo_test.service.ifs;


import com.example.java_demo_test.vo.LoginActivationResponse;
import com.example.java_demo_test.vo.LoginFindByCityResponse;
import com.example.java_demo_test.vo.LoginSignInResponse;
import com.example.java_demo_test.vo.LoginSignUpResponse;

public interface LoginService {

	public LoginSignUpResponse loginSignUp(String account,String pwd,String name,int age,String city);
	
	public LoginActivationResponse loginActivation(String account,String pwd);
	
	public LoginSignInResponse loginSignIn(String account,String pwd);
	
	public LoginFindByCityResponse loginFindByCity(String city);

	
}

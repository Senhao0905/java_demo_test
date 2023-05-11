package com.example.java_demo_test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.java_demo_test.entity.Login;
import com.example.java_demo_test.entity.PersonInfo;
import com.example.java_demo_test.repository.LoginDao;
import com.example.java_demo_test.repository.PersonInfoDao;
import com.example.java_demo_test.service.ifs.LoginService;
import com.example.java_demo_test.service.ifs.PersonInfoService;
import com.example.java_demo_test.vo.GetPersonInfoResponse;

@SpringBootTest(classes = JavaDemoTestApplication.class)
public class SignUpTest {

	@Autowired
	private LoginDao loginDao;

	@Autowired
	private PersonInfoDao personInfoDao;

	@Autowired
	private LoginService loginService;

	@Autowired
	private PersonInfoService personInfoService;

	@Test
	public void Activation() {
		String accString = "udn8895";
		String pwdString = "zxc@883388";

		loginService.loginActivation(accString, pwdString);
	}

	@Test
	public void SignIn() {
		String accString = "udn8895";
		String pwdString = "zxc883388";

		loginService.loginSignIn(accString, pwdString);
	}

	@Test
	public void findByCity() {
		String city = "屏";

		loginService.loginFindByCity(city);
	}

	@Test
	public void sss() {
		int x = personInfoDao.updateNameById("A01", "陳聖和", 23, "屏東");
		System.out.println(x);
	}

	@Test
	public void jpaTest() {
		// return all
		GetPersonInfoResponse res = personInfoService.getPersonInfoByNameContainingAndCityContaining1("", "");
		Assert.isTrue(res.getPersonInfos().size() == 12, "no");
		// no return
		res = personInfoService.getPersonInfoByNameContainingAndCityContaining2("", "");
		Assert.isTrue(res.getPersonInfos().size() == 0, "no");
		// city = null
		res = personInfoService.getPersonInfoByNameContainingAndCityContaining2("李", "");
		Assert.isTrue(res.getPersonInfos().size() == 4, "no");
		// name = null
		res = personInfoService.getPersonInfoByNameContainingAndCityContaining2("", "屏");
		Assert.isTrue(res.getPersonInfos().size() == 4, "no");
		// normal
		res = personInfoService.getPersonInfoByNameContainingAndCityContaining2("李", "屏");
		Assert.isTrue(res.getPersonInfos().size() == 8, "no");
	}

	@Test
	public void queryTest() {
		// return all
		GetPersonInfoResponse res = personInfoService.querySearchByNameOrCity("", "");
		Assert.isTrue(res.getPersonInfos().size() == 12, "no");
		// no return
		res = personInfoService.querySearchByNameOrCity2("", "");
		Assert.isTrue(res.getPersonInfos().size() == 0, "no");
		// city = null
		res = personInfoService.querySearchByNameOrCity2("李", "");
		Assert.isTrue(res.getPersonInfos().size() == 4, "no");
		// name = null
		res = personInfoService.querySearchByNameOrCity2("", "屏");
		Assert.isTrue(res.getPersonInfos().size() == 4, "no");
		// normal
		res = personInfoService.querySearchByNameOrCity2("李", "屏");
		Assert.isTrue(res.getPersonInfos().size() == 8, "no");
	}

	@Test
	public void regexpTest() {
		// return all
		GetPersonInfoResponse res = personInfoService.regexpSearchByNameOrCity("", "");
		Assert.isTrue(res.getPersonInfos().size() == 12, "no");
		// no return
		res = personInfoService.regexpSearchByNameOrCity2("", "");
		Assert.isTrue(res.getPersonInfos().size() == 0, "no");
		// city = null
		res = personInfoService.regexpSearchByNameOrCity2("李", "");
		Assert.isTrue(res.getPersonInfos().size() == 4, "no");
		// name = null
		res = personInfoService.regexpSearchByNameOrCity2("", "屏");
		Assert.isTrue(res.getPersonInfos().size() == 4, "no");
		// normal
		res = personInfoService.regexpSearchByNameOrCity2("李", "屏");
		Assert.isTrue(res.getPersonInfos().size() == 8, "no");
	}

}

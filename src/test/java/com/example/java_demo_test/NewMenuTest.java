package com.example.java_demo_test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.java_demo_test.entity.NewMenu2;
import com.example.java_demo_test.entity.PersonInfo;
import com.example.java_demo_test.repository.NewMenu2Dao;
import com.example.java_demo_test.repository.NewMenuDao;
import com.example.java_demo_test.repository.PersonInfoDao;

@SpringBootTest(classes = JavaDemoTestApplication.class)
public class NewMenuTest {
	
	@Autowired
	private NewMenuDao newMenuDao;
	
	@Autowired
	private PersonInfoDao personInfoDao;
	
	@Autowired
	private NewMenu2Dao newMenu2Dao;
	
	@Test
	public void addDataTest() {
		NewMenu2 newMenu2 = new NewMenu2("¤û", "²M»]",140);
		newMenu2Dao.save(newMenu2);
		String keyString = "¤û";
//		newMenu2Dao.findById();
	}
	
	@Test
	public void test() {
		List<PersonInfo> res = personInfoDao.findByAge(23);
		System.out.println("§½¼Æ");
	}

	

}

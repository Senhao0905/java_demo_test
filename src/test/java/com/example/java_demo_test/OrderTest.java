package com.example.java_demo_test;

import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.java_demo_test.entity.Menu;
import com.example.java_demo_test.repository.OrderDao;
import com.example.java_demo_test.service.ifs.OrderService;
import com.example.java_demo_test.vo.OrderResponse;
import com.fasterxml.jackson.core.sym.Name;

import net.bytebuddy.agent.VirtualMachine.ForHotSpot.Connection.Response;


@SpringBootTest(classes = JavaDemoTestApplication.class)
class OrderTest {

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private OrderService orderService;
		
	@Test
	public void addMenusTest() {
		List<Menu> menus = new ArrayList<Menu>();
		//�浧
		menus.add(new Menu("�f�X�q�j�Q��", 75));
		//�h��
		menus.add(new Menu("��O����", 175));
//		menus.add(new Menu("����", 65));
//		menus.add(new Menu("�ز�����", 190));
		//�浧���~
//		menus.add(new Menu("   ", 75));
//		menus.add(new Menu("������", -100));
		OrderResponse response = orderService.addMenus(menus);
		Assert.isTrue(response.getMessage().equals("�\�I�s�W���\"), "���W�ǥ���");
	}
	
	@Test
	public void orderMenuTest() {
		Map< String,Integer> Map = new LinkedHashMap<>();
		//�涵�I�\
		Map.put("beef" , 2);
		//�h���I�\
		Map.put("pork" , 1);
		Map.put("fish" , 2);		
		OrderResponse response = orderService.orderMenus(Map);
		Assert.isTrue(response.getMessage().equals("�I�\���\"), "�I�\����");
		
	}

	

}

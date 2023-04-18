package com.example.java_demo_test.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.hibernate.boot.model.naming.ImplicitNameSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.java_demo_test.entity.Bank;
import com.example.java_demo_test.entity.Menu;
import com.example.java_demo_test.repository.OrderDao;
import com.example.java_demo_test.service.ifs.OrderService;
import com.example.java_demo_test.vo.BankResponse;
import com.example.java_demo_test.vo.GetMenuResponse;
import com.example.java_demo_test.vo.OrderResponse;
import com.fasterxml.jackson.core.sym.Name;
import com.fasterxml.jackson.databind.introspect.DefaultAccessorNamingStrategy.FirstCharBasedValidator;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	@Override
	public OrderResponse addMenus(List<Menu> menus) {

		// �ۤv�g�k
//		int lenth = 0;
//		List<Menu> resList = new ArrayList<Menu>();
//		while (lenth < menus.size()) {
//			Menu menu = menus.get(lenth);
//			if (menu == null || !StringUtils.hasText(menu.getName())) {
//				System.out.println("��" + (lenth + 1) + "�����W�ٿ��~");
//				lenth++;
//				continue;
//			}
//			if (menu.getPrice() <= 0) {
//				System.out.println("��" + (lenth + 1) + "����������~");
//				lenth++;
//				continue;
//			}			
//			resList.add(menu);
//			lenth++;
//		}
//		if (resList.size() == 0) {
//			return new OrderResponse(resList, "���W�ǥ���");
//		}
//		
//		orderDao.saveAll(resList);
//		
//		return new OrderResponse(resList, "���W�ǧ���");

		// �Ѯv�g�k

		// CollectionUtils.isEmpty�i�H�P�ɧP�_�O�_���Ŷ��X�άONull
		if (CollectionUtils.isEmpty(menus)) {
			return new OrderResponse("�s�W�\�I���~");
		}
		// ����W��
//		if(menus == null || menus.isEmpty()){
//			return new OrderResponse("�s�W�\�I���~");
//		}
		for (Menu menuName : menus) {
			if (!StringUtils.hasText(menuName.getName())) {
				return new OrderResponse("�s�W�\�I���~");
			}
			if (menuName.getPrice() <= 0) {
				return new OrderResponse("�\�I������~");
			}

		}

		List<Menu> resMenus = orderDao.saveAll(menus);

		return new OrderResponse(resMenus, "�\�I�s�W���\");

	}

	@Override
	public OrderResponse orderMenus(Map<String, Integer> map) {
		// �ۤv����
//		int lenth = 0;
//		int price = 0;
//		int disountPrice = 0;
//		Map<String, Integer> resMap = new LinkedHashMap<>();
//
//		for (Map.Entry m : map.entrySet()) { 
//
//			if (!StringUtils.hasText((String) m.getKey())) {
//				System.out.println("��" + (lenth + 1) + "���\�I�W�٬��ť�");
//				lenth++;
//				continue;
//			}
//
//			if ((int) m.getValue() <= 0) {
//				System.out.println("��" + (lenth + 1) + "���I�\�ƶq���~");
//				lenth++;
//				continue;
//			}
//
//			Menu resmenu = orderDao.findByName((String) m.getKey());
//
//			if (resmenu == null) {
//				System.out.println((String) m.getKey() + "���b��椤");
//				lenth++;
//				continue;
//			}
//
//			price += resmenu.getPrice() * (int) m.getValue();
//
//			resMap.put(resmenu.getName(), (int) m.getValue());
//
//			lenth++;
//		}
//
//		if (resMap.size() == 0) {
//			return new OrderResponse("�I�\����", resMap, price, disountPrice);
//		}
//
//		if (price < 500) {
//			return new OrderResponse("�I�\���\", resMap, price, price);
//		}
//
//		disountPrice = (int) (price * 0.9);

		// �Ѯv����
//		Map<String, Integer> resMap = new HashMap<>();
//		List<String> nameList = new ArrayList<>();
//		for (Entry<String, Integer> m : map.entrySet()) {
//			if (m.getValue() < 0) {
//				return new OrderResponse("�\�I�ƶq���~");
//			}
//			nameList.add(m.getKey());
//		}
//		List<Menu> response = orderDao.findAllById(nameList);
//		int originalTotalPrice = 0;
//		for (Menu menu : response) {
//			String name = menu.getName();
//			int price = menu.getPrice();
//			for (Entry<String, Integer> m : map.entrySet()) {
//				String key = m.getKey();
//				int value = m.getValue();
//				if (name.equalsIgnoreCase(key)) {
//					originalTotalPrice += (price * value);
//					resMap.put(key, value);
//				}
//			}
//		}
		// �ק�
		Map<String, Integer> resMap = new HashMap<>();
		List<Menu> menus = orderDao.findAll();
		int originalTotalPrice = 0;
		for (Menu menu : menus) {
			for (Entry<String, Integer> m : map.entrySet()) {
				if (menu.getName().equalsIgnoreCase(m.getKey())) {
					if (m.getValue() <= 0) {
						return new OrderResponse("�\�I�ƶq���~");
					}
					originalTotalPrice += (menu.getPrice() * m.getValue());
					resMap.put(m.getKey(), m.getValue());
					break;
				}
			}
		}

		if (originalTotalPrice < 500) {
			return new OrderResponse("�I�\���\", resMap, originalTotalPrice, originalTotalPrice);
		}

		int discountPrice = (int) (originalTotalPrice * 0.9);

		return new OrderResponse("�I�\���\", resMap, originalTotalPrice, discountPrice);

	}

	@Override
	public GetMenuResponse getMenuByName(String name) {

		if (!StringUtils.hasText(name)) {
			return new GetMenuResponse("�W�٤���ť�");
		}

		Optional<Menu> op = orderDao.findById(name);

		if (!op.isPresent()) {
			return new GetMenuResponse("�S���o���\�I");
		}

		return new GetMenuResponse(op.get(), "�d�ߦ��\");
	}

}

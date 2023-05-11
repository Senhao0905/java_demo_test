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

import net.bytebuddy.utility.dispatcher.JavaDispatcher.IsConstructor;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	@Override
	public OrderResponse addMenus(List<Menu> menus) {

		// 自己寫法
//		int lenth = 0;
//		List<Menu> resList = new ArrayList<Menu>();
//		while (lenth < menus.size()) {
//			Menu menu = menus.get(lenth);
//			if (menu == null || !StringUtils.hasText(menu.getName())) {
//				System.out.println("第" + (lenth + 1) + "筆菜單名稱錯誤");
//				lenth++;
//				continue;
//			}
//			if (menu.getPrice() <= 0) {
//				System.out.println("第" + (lenth + 1) + "筆菜單價格錯誤");
//				lenth++;
//				continue;
//			}			
//			resList.add(menu);
//			lenth++;
//		}
//		if (resList.size() == 0) {
//			return new OrderResponse(resList, "菜單上傳失敗");
//		}
//		
//		orderDao.saveAll(resList);
//		
//		return new OrderResponse(resList, "菜單上傳完成");

		// 老師寫法

		// CollectionUtils.isEmpty可以同時判斷是否為空集合或是Null
		if (CollectionUtils.isEmpty(menus)) {
			return new OrderResponse("新增餐點錯誤");
		}
		// 等於上面
//		if(menus == null || menus.isEmpty()){
//			return new OrderResponse("新增餐點錯誤");
//		}
		for (Menu menuName : menus) {
			if (!StringUtils.hasText(menuName.getName())) {
				return new OrderResponse("新增餐點錯誤");
			}
			if (menuName.getPrice() <= 0) {
				return new OrderResponse("餐點價格錯誤");
			}

		}

		List<Menu> resMenus = orderDao.saveAll(menus);

		return new OrderResponse(resMenus, "餐點新增成功");

	}

	@Override
	public OrderResponse orderMenus(Map<String, Integer> map) {
		// 自己做的
//		int lenth = 0;
//		int price = 0;
//		int disountPrice = 0;
//		Map<String, Integer> resMap = new LinkedHashMap<>();
//
//		for (Map.Entry m : map.entrySet()) { 
//
//			if (!StringUtils.hasText((String) m.getKey())) {
//				System.out.println("第" + (lenth + 1) + "筆餐點名稱為空白");
//				lenth++;
//				continue;
//			}
//
//			if ((int) m.getValue() <= 0) {
//				System.out.println("第" + (lenth + 1) + "筆點餐數量錯誤");
//				lenth++;
//				continue;
//			}
//
//			Menu resmenu = orderDao.findByName((String) m.getKey());
//
//			if (resmenu == null) {
//				System.out.println((String) m.getKey() + "不在菜單中");
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
//			return new OrderResponse("點餐失敗", resMap, price, disountPrice);
//		}
//
//		if (price < 500) {
//			return new OrderResponse("點餐成功", resMap, price, price);
//		}
//
//		disountPrice = (int) (price * 0.9);

		// 老師做的
//		Map<String, Integer> resMap = new HashMap<>();
//		List<String> nameList = new ArrayList<>();
//		for (Entry<String, Integer> m : map.entrySet()) {
//			if (m.getValue() < 0) {
//				return new OrderResponse("餐點數量錯誤");
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
		// 修改
		Map<String, Integer> resMap = new HashMap<>();
		
		int originalTotalPrice = 0;
		
		for (Entry<String, Integer> m : map.entrySet()) {
			if(m.getValue() <= 0) {
				return new OrderResponse("數量錯誤");
			}
			Optional<Menu> op = orderDao.findById(m.getKey()); //盡量不要在迴圈中進入資料庫
			if(!op.isPresent()) {
				continue;
			}
			
			resMap.put(m.getKey(), m.getValue());
			
			originalTotalPrice += op.get().getPrice() * m.getValue();
		}
		

		// 作業
//		Map<String, Integer> resMap = new HashMap<>();
//		List<Menu> menus = orderDao.findAll();
//		for (Menu menu : menus) {
//			for (Entry<String, Integer> m : map.entrySet()) {
//				if (m.getValue() <= 0) {
		
//					return new OrderResponse("數量錯誤");
		
//				}				
//				if (orderDao.existsById(m.getKey())) {	
//					if (menu.getName().equals(m.getKey())) {
		
//						originalTotalPrice += menu.getPrice() * m.getValue();
		
//						resMap.put(m.getKey(), m.getValue());
		
//					}
//				}
//			}
//		}

		if (resMap.size() == 0) {
			return new OrderResponse("點餐失敗");
		}

		

		if (originalTotalPrice < 500) {
			return new OrderResponse("點餐成功", resMap, originalTotalPrice, originalTotalPrice);
		}

		int discountPrice = (int) (originalTotalPrice * 0.9);

		return new OrderResponse("點餐成功", resMap, originalTotalPrice, discountPrice);

	}

	@Override
	public GetMenuResponse getMenuByName(String name) {

		if (!StringUtils.hasText(name)) {
			return new GetMenuResponse("名稱不能空白");
		}

		Optional<Menu> op = orderDao.findById(name);

		if (!op.isPresent()) {
			return new GetMenuResponse("沒有這個餐點");
		}

		return new GetMenuResponse(op.get(), "查詢成功");
	}

	@Override
	public OrderResponse updateMenuPrice(List<Menu> menus) {
		if (CollectionUtils.isEmpty(menus)) {
			return new OrderResponse("格式錯誤");
		}
		// orderdao.existsById 檢查id是否存在資料庫 結果為布林值
		// 此寫法須注意資料庫大小 大量資料時不太適合
		List<Menu> menu = orderDao.findAll();
		List<Menu> resMenu = new ArrayList<Menu>();
		for (Menu change : menus) {
			for (Menu original : menu) {
				if (change.getPrice() <= 0) {
					return new OrderResponse("價格不能為0或負數");
				}
				if (change.getName().equalsIgnoreCase(original.getName())) {
					resMenu.add(change);
				}
			}
		}
		if (resMenu.size() == 0) {
			return new OrderResponse("菜單不存在");
		}
		return new OrderResponse(orderDao.saveAll(resMenu), "價格修改成功");
	}

	@Override
	public OrderResponse getMenu() {
		return new OrderResponse(orderDao.findAll(), "菜單");
	}
}

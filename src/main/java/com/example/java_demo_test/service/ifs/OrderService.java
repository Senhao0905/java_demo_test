package com.example.java_demo_test.service.ifs;


import java.util.List;
import java.util.Map;

import com.example.java_demo_test.entity.Menu;
import com.example.java_demo_test.vo.GetMenuResponse;
import com.example.java_demo_test.vo.OrderResponse;



public interface OrderService {
	
	public GetMenuResponse getMenuByName(String name);
	
	public OrderResponse addMenus(List<Menu> menus);
	
	public OrderResponse orderMenus(Map<String, Integer> map);

}

package com.example.java_demo_test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_demo_test.entity.Menu;
import com.example.java_demo_test.service.ifs.OrderService;
import com.example.java_demo_test.vo.GetMenuResponse;
import com.example.java_demo_test.vo.OrderRequest;
import com.example.java_demo_test.vo.OrderResponse;


@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping(value = "add_menus")
	public OrderResponse addMenus(@RequestBody OrderRequest request) {

		return orderService.addMenus(request.getMenus());

	}

	@PostMapping(value = "order_menus")
	public OrderResponse orderMenus(@RequestBody OrderRequest request) {

		return orderService.orderMenus(request.getMap());

	}

	@PostMapping(value = "get_menu_by_name")
	public GetMenuResponse getMenuByName(@RequestBody OrderRequest request) {

		return orderService.getMenuByName(request.getName());

	}
	
	@PostMapping(value = "update_menu_price")
	public OrderResponse updateMenuPrice (@RequestBody OrderRequest request) {
		return orderService.updateMenuPrice(request.getMenus());
	}
	
	@PostMapping(value = "get_menu")
	public OrderResponse getMenu() {
		return orderService.getMenu();		
	}

}

package com.example.java_demo_test.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.java_demo_test.entity.Menu;

public class OrderResponse {
	private List<Menu> menus = new ArrayList<Menu>();

	private String message;

	private Map<String, Integer> map = new HashMap<>();

	private int price;

	private int discontPrice;

	public OrderResponse() {

	}

	public OrderResponse(String message) {		
		this.message = message;
	}

	public OrderResponse(List<Menu> menus, String message) {

		this.menus = menus;
		this.message = message;
	}

	

	public OrderResponse(String message, Map<String, Integer> map, int price, int discontPrice) {
		super();
		this.message = message;
		this.map = map;
		this.price = price;
		this.discontPrice = discontPrice;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public Map<String, Integer> getMap() {
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscontPrice() {
		return discontPrice;
	}

	public void setDiscontPrice(int discontPrice) {
		this.discontPrice = discontPrice;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

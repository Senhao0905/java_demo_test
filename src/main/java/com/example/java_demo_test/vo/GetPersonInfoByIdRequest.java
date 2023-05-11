package com.example.java_demo_test.vo;


import com.fasterxml.jackson.annotation.JsonProperty;

public class GetPersonInfoByIdRequest {
	@JsonProperty("age")
	int age;
	
	@JsonProperty("id")
	String id;
	
	@JsonProperty("city")
	String city ;
	
	@JsonProperty("to")
	int to ;
	
	@JsonProperty("go")
	int go ;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public int getGo() {
		return go;
	}

	public void setGo(int go) {
		this.go = go;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	
	
}

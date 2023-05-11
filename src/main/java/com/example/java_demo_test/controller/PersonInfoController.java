package com.example.java_demo_test.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.java_demo_test.service.ifs.PersonInfoService;
import com.example.java_demo_test.vo.AddPersonInfoRequest;
import com.example.java_demo_test.vo.GetPersonInfoByIdRequest;
import com.example.java_demo_test.vo.GetPersonInfoResponse;
import com.example.java_demo_test.vo.PersonInfoResponse;

import io.swagger.v3.oas.annotations.Hidden;

@RestController
public class PersonInfoController {

	@Autowired
	private PersonInfoService personInfoService;
	
	@PostMapping(value = "add_person_info")
	public PersonInfoResponse addPersonInfo(@RequestBody AddPersonInfoRequest request) {
		
		return personInfoService.addPersonInfo(request.getPersonInfoList());
		
	}
	//ÁôÂÃapiªº@
	//@ApiIgnore 
	//@Hidden
	@GetMapping(value = "get_all_person_info")
	public GetPersonInfoResponse getAllPersonInfo() {
		return personInfoService.getAllPersonInfo();
		
	}
		
	@PostMapping(value = "get_person_info_by_id")
	public GetPersonInfoResponse getPersonInfoById(@RequestBody GetPersonInfoByIdRequest request) {
		
		return personInfoService.getPersonInfoById(request.getId());
		
	}
	
	@PostMapping(value = "get_person_info_by_age_greaterthan")
	public GetPersonInfoResponse getPersonInfoByAgeGreaterThan(@RequestBody GetPersonInfoByIdRequest request) {
		return personInfoService.getPersonInfoByAgeGreaterThan(request.getAge());
	}
	
	@PostMapping(value ="get_person_info_by_age_less_than_equal")
	public GetPersonInfoResponse getPersonInfoByAgeLessThanEqual(@RequestBody GetPersonInfoByIdRequest request) {
		return personInfoService.getPersonInfoByAgeLessThanEqual(request.getAge());
		
	}

	@PostMapping(value ="get_person_info_by_age_between")
	public GetPersonInfoResponse getPersonInfoByAgeBetween(@RequestBody GetPersonInfoByIdRequest request) {
		return personInfoService.getPersonInfoByAgeBetween(request.getTo(),request.getGo());
		
	}
	
	@PostMapping(value ="get_person_info_by_city_containing")
	public GetPersonInfoResponse getPersonInfoByCityContaining(@RequestBody GetPersonInfoByIdRequest request) {
		return personInfoService.getPersonInfoByCityContaining(request.getCity());
		
	}
	@PostMapping(value ="get_Person_Info_By_Age_And_City_Containing")
	public GetPersonInfoResponse getPersonInfoByAgeAndCityContaining(@RequestBody GetPersonInfoByIdRequest request) {
		return personInfoService.getPersonInfoByAgeAndCityContaining(request.getAge(), request.getCity());
		
	}
	
	@PostMapping(value ="get_Person_Info_By_Age_GreaterThan_Or_Age_LessThan")
	public GetPersonInfoResponse getPersonInfoByAgeGreaterThanOrAgeLessThan(@RequestBody GetPersonInfoByIdRequest request) {
		return personInfoService.getPersonInfoByAgeGreaterThanOrAgeLessThan(request.getAge(), request.getGo());
	}
	
}

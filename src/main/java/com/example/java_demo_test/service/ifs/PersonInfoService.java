package com.example.java_demo_test.service.ifs;

import java.util.List;

import com.example.java_demo_test.entity.PersonInfo;
import com.example.java_demo_test.vo.GetPersonInfoResponse;
import com.example.java_demo_test.vo.PersonInfoResponse;

public interface PersonInfoService {

	public PersonInfoResponse addPersonInfo(List<PersonInfo> personInfoList);

	public GetPersonInfoResponse getAllPersonInfo();

	public GetPersonInfoResponse getPersonInfoById(String id);

	public GetPersonInfoResponse getPersonInfoByAgeGreaterThan(int age);

	public GetPersonInfoResponse getPersonInfoByAgeGreaterThanOrAgeLessThan(int age1, int age2);

	public GetPersonInfoResponse getPersonInfoByAgeLessThanEqual(int age);

	public GetPersonInfoResponse getPersonInfoByAgeBetween(int start, int end);

	public GetPersonInfoResponse getPersonInfoByCityContaining(String city);

	public GetPersonInfoResponse getPersonInfoByAgeAndCityContaining(int age, String str);

	public GetPersonInfoResponse getPersonInfoByNameContainingAndCityContaining1(String name, String vity);

	public GetPersonInfoResponse getPersonInfoByNameContainingAndCityContaining2(String name, String vity);

	public GetPersonInfoResponse querySearchByNameOrCity(String name, String city);

	public GetPersonInfoResponse querySearchByNameOrCity2(String name, String city);
	
	public GetPersonInfoResponse regexpSearchByNameOrCity(String name, String city);
	
	public GetPersonInfoResponse regexpSearchByNameOrCity2(String name, String city);

}

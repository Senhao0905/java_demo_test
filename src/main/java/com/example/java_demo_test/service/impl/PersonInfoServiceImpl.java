package com.example.java_demo_test.service.impl;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.java_demo_test.entity.PersonInfo;
import com.example.java_demo_test.repository.PersonInfoDao;

import com.example.java_demo_test.service.ifs.PersonInfoService;
import com.example.java_demo_test.vo.GetPersonInfoResponse;
import com.example.java_demo_test.vo.PersonInfoResponse;

@Service
public class PersonInfoServiceImpl implements PersonInfoService {

	@Autowired
	private PersonInfoDao personInfoDao;

	@Override
	public PersonInfoResponse addPersonInfo(List<PersonInfo> personInfoList) {

		// 檢查參數(防呆)
		// 1.檢查陣列是否為null或空
//		city.addAll(List.of(""));

		List<String> ids = new ArrayList<>();

		if (CollectionUtils.isEmpty(personInfoList)) {
			return new PersonInfoResponse("格式錯誤");
		}
		// 2.檢查每項資訊中的內容
		for (PersonInfo person : personInfoList) {
			if (!StringUtils.hasText(person.getId())) {
				return new PersonInfoResponse("ID錯誤");
			}

			if (!StringUtils.hasText(person.getName())) {
				return new PersonInfoResponse("名稱錯誤");
			}

			if (person.getAge() < 0) {
				return new PersonInfoResponse("年齡錯誤");
			}

			if (!StringUtils.hasText(person.getCity())) {
				return new PersonInfoResponse("地區錯誤錯誤");
			}

			ids.add(person.getId());
		}

		List<PersonInfo> res = personInfoDao.findAllById(ids);
		List<PersonInfo> response = new ArrayList<>();
		List<String> id = new ArrayList<>();

//		if (res.size() > 0) {
//
//			for (PersonInfo haveInfo : res) {
//				id.add(haveInfo.getId());
//			}
//			for (PersonInfo personInfo : personInfoList) {
//				if (!id.contains(personInfo.getId())) {
//					response.add(personInfo);
//				}
//			}
//			if(response.size() == 0) {
//				return new PersonInfoResponse("新增錯誤");
//			}
//
//			return new PersonInfoResponse("新增成功", personInfoDao.saveAll(response));
//
//		}
		// 判斷輸入的id是否已存在資料庫
		if (res.size() == personInfoList.size()) {
			return new PersonInfoResponse("新增資料已存在");
		}
		if (res.size() > 0) {
			for (PersonInfo person : personInfoList) {// a.b.c.d.e
				boolean x = false;
				for (PersonInfo haveInfo : res) {// c.d
					if (person.getId().equalsIgnoreCase(haveInfo.getId())) {
						x = true;
					}
				}
				if (x) {
					continue;
				}
				response.add(person);
			}

			return new PersonInfoResponse("新增成功", personInfoDao.saveAll(response));
		}

		return new PersonInfoResponse("新增成功", personInfoDao.saveAll(personInfoList));
	}

	@Override
	public GetPersonInfoResponse getAllPersonInfo() {

		return new GetPersonInfoResponse(personInfoDao.findAll(), "查詢成功");
	}

	@Override
	public GetPersonInfoResponse getPersonInfoById(String id) {
		if (!StringUtils.hasLength(id)) {
			return new GetPersonInfoResponse("id 不能為空");
		}
		Optional<PersonInfo> op = personInfoDao.findById(id);
		if (!op.isPresent()) {
			return new GetPersonInfoResponse("查無此資料");
		}

		return new GetPersonInfoResponse(op.get(), "查詢成功");

	}

	@Override
	public GetPersonInfoResponse getPersonInfoByAgeGreaterThan(int age) {
		List<PersonInfo> res = personInfoDao.findByAgeGreaterThan(age);
		return new GetPersonInfoResponse(res, "成功");
	}

	@Override
	public GetPersonInfoResponse getPersonInfoByAgeLessThanEqual(int age) {

		List<PersonInfo> res = personInfoDao.findByAgeLessThanEqualOrderByAgeAsc(age);
		return new GetPersonInfoResponse(res, "成功");
	}

	@Override
	public GetPersonInfoResponse getPersonInfoByAgeBetween(int start, int end) {
		List<PersonInfo> res = personInfoDao.findTop3ByAgeBetweenOrderByAgeAsc(start, end);
		return new GetPersonInfoResponse(res, "成功");
	}

	@Override
	public GetPersonInfoResponse getPersonInfoByCityContaining(String city) {
		List<PersonInfo> res = personInfoDao.findByCityContaining(city);
		return new GetPersonInfoResponse(res, "成功");
	}

	@Override
	public GetPersonInfoResponse getPersonInfoByAgeAndCityContaining(int age, String str) {
		List<PersonInfo> res = personInfoDao.findByAgeGreaterThanAndCityContainingOrderByAgeDesc(age, str);
		return new GetPersonInfoResponse(res, "成功");
	}

	@Override
	public GetPersonInfoResponse getPersonInfoByAgeGreaterThanOrAgeLessThan(int age1, int age2) {
		List<PersonInfo> res = personInfoDao.findByAgeGreaterThanOrAgeLessThanOrderByAgeDesc(age1, age2);	
		return new GetPersonInfoResponse(res, "成功");
	}

	
	//練習
	@Override
	public GetPersonInfoResponse getPersonInfoByNameContainingAndCityContaining1(String name, String city) {

		boolean check = !StringUtils.hasText(name) && !StringUtils.hasText(city);
		String newName = check ? "" : StringUtils.hasText(name)? name: null;
		String newCity = check ? "" : StringUtils.hasText(city)? city: null;
		List<PersonInfo> res = personInfoDao.findByNameContainingOrCityContaining(newName, newCity);
		return new GetPersonInfoResponse(res, "ok");
		
	}
	@Override
	public GetPersonInfoResponse getPersonInfoByNameContainingAndCityContaining2(String name, String city) {
		String newName = StringUtils.hasText(name)? name : null;
		String newCity = StringUtils.hasText(city)? city : null;
		
		List<PersonInfo> res = personInfoDao.findByNameContainingOrCityContaining(newName, newCity);
		return new GetPersonInfoResponse(res, "ok");
		
	}

	@Override
	public GetPersonInfoResponse querySearchByNameOrCity(String name, String city) {

		boolean check = !StringUtils.hasText(name) && !StringUtils.hasText(city);
		String newName = check ? "" : StringUtils.hasText(name)? name: null;
		String newCity = check ? "" : StringUtils.hasText(city)? city: null;
		List<PersonInfo> res = personInfoDao.searchByNameOrCity(newName, newCity);
		
		return new GetPersonInfoResponse(res, "ok");
	}

	@Override
	public GetPersonInfoResponse querySearchByNameOrCity2(String name, String city) {
		String newName = StringUtils.hasText(name)? name : null;
		String newCity = StringUtils.hasText(city)? city : null;
		List<PersonInfo> res = personInfoDao.searchByNameOrCity(newName, newCity);
		
		return new GetPersonInfoResponse(res, "ok");
	}

	@Override
	public GetPersonInfoResponse regexpSearchByNameOrCity(String name, String city) {
		
		boolean check = !StringUtils.hasText(name) && !StringUtils.hasText(city);
		String newName = check ? "." : StringUtils.hasText(name)? name: null;
		String newCity = check ? "." : StringUtils.hasText(city)? city: null;
		List<PersonInfo> res = personInfoDao.searchByNameOrCity2(newName, newCity);
		
		return new GetPersonInfoResponse(res, "ok");
	}

	@Override
	public GetPersonInfoResponse regexpSearchByNameOrCity2(String name, String city) {
		String newName = StringUtils.hasText(name)? name: null;
		String newCity = StringUtils.hasText(city)? city : null;
		List<PersonInfo> res = personInfoDao.searchByNameOrCity2(newName, newCity);
		
		return new GetPersonInfoResponse(res, "ok");
	}

	

}

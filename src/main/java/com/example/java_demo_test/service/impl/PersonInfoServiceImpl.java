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

		// �ˬd�Ѽ�(���b)
		// 1.�ˬd�}�C�O�_��null�Ϊ�
//		city.addAll(List.of(""));

		List<String> ids = new ArrayList<>();

		if (CollectionUtils.isEmpty(personInfoList)) {
			return new PersonInfoResponse("�榡���~");
		}
		// 2.�ˬd�C����T�������e
		for (PersonInfo person : personInfoList) {
			if (!StringUtils.hasText(person.getId())) {
				return new PersonInfoResponse("ID���~");
			}

			if (!StringUtils.hasText(person.getName())) {
				return new PersonInfoResponse("�W�ٿ��~");
			}

			if (person.getAge() < 0) {
				return new PersonInfoResponse("�~�ֿ��~");
			}

			if (!StringUtils.hasText(person.getCity())) {
				return new PersonInfoResponse("�a�Ͽ��~���~");
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
//				return new PersonInfoResponse("�s�W���~");
//			}
//
//			return new PersonInfoResponse("�s�W���\", personInfoDao.saveAll(response));
//
//		}
		// �P�_��J��id�O�_�w�s�b��Ʈw
		if (res.size() == personInfoList.size()) {
			return new PersonInfoResponse("�s�W��Ƥw�s�b");
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

			return new PersonInfoResponse("�s�W���\", personInfoDao.saveAll(response));
		}

		return new PersonInfoResponse("�s�W���\", personInfoDao.saveAll(personInfoList));
	}

	@Override
	public GetPersonInfoResponse getAllPersonInfo() {

		return new GetPersonInfoResponse(personInfoDao.findAll(), "�d�ߦ��\");
	}

	@Override
	public GetPersonInfoResponse getPersonInfoById(String id) {
		if (!StringUtils.hasLength(id)) {
			return new GetPersonInfoResponse("id ���ର��");
		}
		Optional<PersonInfo> op = personInfoDao.findById(id);
		if (!op.isPresent()) {
			return new GetPersonInfoResponse("�d�L�����");
		}

		return new GetPersonInfoResponse(op.get(), "�d�ߦ��\");

	}

	@Override
	public GetPersonInfoResponse getPersonInfoByAgeGreaterThan(int age) {
		List<PersonInfo> res = personInfoDao.findByAgeGreaterThan(age);
		return new GetPersonInfoResponse(res, "���\");
	}

	@Override
	public GetPersonInfoResponse getPersonInfoByAgeLessThanEqual(int age) {

		List<PersonInfo> res = personInfoDao.findByAgeLessThanEqualOrderByAgeAsc(age);
		return new GetPersonInfoResponse(res, "���\");
	}

	@Override
	public GetPersonInfoResponse getPersonInfoByAgeBetween(int start, int end) {
		List<PersonInfo> res = personInfoDao.findTop3ByAgeBetweenOrderByAgeAsc(start, end);
		return new GetPersonInfoResponse(res, "���\");
	}

	@Override
	public GetPersonInfoResponse getPersonInfoByCityContaining(String city) {
		List<PersonInfo> res = personInfoDao.findByCityContaining(city);
		return new GetPersonInfoResponse(res, "���\");
	}

	@Override
	public GetPersonInfoResponse getPersonInfoByAgeAndCityContaining(int age, String str) {
		List<PersonInfo> res = personInfoDao.findByAgeGreaterThanAndCityContainingOrderByAgeDesc(age, str);
		return new GetPersonInfoResponse(res, "���\");
	}

	@Override
	public GetPersonInfoResponse getPersonInfoByAgeGreaterThanOrAgeLessThan(int age1, int age2) {
		List<PersonInfo> res = personInfoDao.findByAgeGreaterThanOrAgeLessThanOrderByAgeDesc(age1, age2);	
		return new GetPersonInfoResponse(res, "���\");
	}

	
	//�m��
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

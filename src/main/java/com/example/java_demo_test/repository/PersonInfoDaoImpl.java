package com.example.java_demo_test.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.java_demo_test.entity.PersonInfo;

public class PersonInfoDaoImpl extends BaseDao {

	public List<PersonInfo> doQueryByAge(int age) {

		StringBuffer sb = new StringBuffer();

		sb.append("select p from PersonInfo p where p.age >= :age");

		Map<String, Object> params = new HashMap<String, Object>();

		params.put("age", age);

		return doQuery(sb.toString(), params, PersonInfo.class);
	}

	public List<PersonInfo> doQueryByAge(int age, int limit) {

		StringBuffer sb = new StringBuffer();

		sb.append("select p from PersonInfo p where p.age >= :age");

		Map<String, Object> params = new HashMap<String, Object>();

		params.put("age", age);

		return doQuery(sb.toString(), params, PersonInfo.class, limit);

	}

	public List<PersonInfo> doQueryByAge(int age, int limit, int startPosition) {

		StringBuffer sb = new StringBuffer();

		sb.append("select p from PersonInfo p where p.age >= :age");

		Map<String, Object> params = new HashMap<String, Object>();

		params.put("age", age);

		return doQuery(sb.toString(), params, PersonInfo.class, limit, startPosition);

	}

	public int doUpdateAgeByName(int newAge, int name) {

		StringBuffer sb = new StringBuffer();

		sb.append("update PersonInfo p set p.age = :newAge where p.name = :name");

		Map<String, Object> params = new HashMap<String, Object>();

		params.put("newAge", newAge);
		params.put("name", name);

		return doUpdate(sb.toString(), params);
	}
}

package com.example.java_demo_test.repository;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.util.CollectionUtils;

public class BaseDao {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected <EntityType> List<EntityType> doQuery(String sql, Map<String, Object> params, Class<EntityType> clazz) {

//		if (!CollectionUtils.isEmpty(params)) {
//			// 1
//			for (Entry<String, Object> item : params.entrySet()) {
//				query.setParameter(item.getKey(), item.getValue());
//			}
//			//2
//			for(Parameter p:query.getParameters()) {
//				query.setParameter(p, params.get(p.getName()));
//			}
//		}
		return doQuery(sql, params, clazz, -1);

	}

	/*
	 * 限制回傳筆數
	 */
	protected <EntityType> List<EntityType> doQuery(String sql, Map<String, Object> params, Class<EntityType> clazz,
			int limit) {

		return doQuery(sql, params, clazz, limit, -1);

	}

	/*
	 * limit:限制回傳筆數 startPosition:分頁起始位置
	 */
	@SuppressWarnings("unchecked")
	protected <EntityType> List<EntityType> doQuery(String sql, Map<String, Object> params, Class<EntityType> clazz,
			int limit, int startPosition) {

		Query query = entityManager.createQuery(sql, clazz);
		if (!CollectionUtils.isEmpty(params)) {

			for (Entry<String, Object> item : params.entrySet()) {
				query.setParameter(item.getKey(), item.getValue());
			}

		}

		if (limit > 0) {
			query.setMaxResults(limit);
		}

		if (startPosition >= 0) {
			query.setFirstResult(startPosition);
		}

		return query.getResultList();
	}

	protected int doUpdate(String sql, Map<String, Object> params) {

		Query query = entityManager.createQuery(sql);
		if (!CollectionUtils.isEmpty(params)) {

			for (Entry<String, Object> item : params.entrySet()) {
				query.setParameter(item.getKey(), item.getValue());
			}

		}

		return query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	protected <EntityType> List<EntityType> doNativeQuery(String sql, Map<String, Object> params,
			Class<EntityType> clazz, int limit, int startPosition) {

		Query query = entityManager.createNativeQuery(sql, clazz);
		if (!CollectionUtils.isEmpty(params)) {

			for (Entry<String, Object> item : params.entrySet()) {
				query.setParameter(item.getKey(), item.getValue());
			}

		}

		if (limit > 0) {
			query.setMaxResults(limit);
		}

		if (startPosition >= 0) {
			query.setFirstResult(startPosition);
		}

		return query.getResultList();
	}

}

package com.example.java_demo_test.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.java_demo_test.entity.PersonInfo;



@Repository
public interface PersonInfoDao extends JpaRepository<PersonInfo, String> {
	
	
		public List<PersonInfo> findByAge(int age);
		
		public List<PersonInfo> findByAgeGreaterThan(int age);
		
		public List<PersonInfo> findByAgeLessThanEqualOrderByAgeAsc(int age);
		
		public List<PersonInfo> findTop3ByAgeBetweenOrderByAgeAsc(int start , int end);
		
		public List<PersonInfo> findByCityContaining(String city);
		
		public List<PersonInfo> findByAgeGreaterThanAndCityContainingOrderByAgeDesc(int age,String city);
		
		public List<PersonInfo> findByAgeGreaterThanOrAgeLessThanOrderByAgeDesc(int age1 , int age2);

		public List<PersonInfo> doQueryByAge(int age , int limit);
		
		public List<PersonInfo> doQueryByAge(int age);
		
		public List<PersonInfo> doQueryByAge(int age , int limit, int startPosition);
		
		
		
		@Transactional
		public int doUpdateAgeByName(int newAge ,int name);
		
		@Transactional
		@Modifying
		@Query("update PersonInfo p set p.id= :newID , p.name= :newName ,p.age= :newAge,"
				+ "p.city= :newCity where p.id= :newID")
		public int updateNameById(
				@Param("newID") String inputId,
				@Param("newName") String inputName,
				@Param("newAge") int inputAge,
				@Param("newCity") String inputCity);
		
		//JPA
		public List<PersonInfo> findByNameContainingOrCityContaining(String name , String city);
		
		
		//query
		@Query("SELECT p FROM PersonInfo p"
				+ " where p.name like concat ('%',:keyName,'%') "
				+ "or p.city like concat ('%',:keyCity,'%') ")
		public List<PersonInfo> searchByNameOrCity(
				@Param("keyName")String keyName,
				@Param("keyCity")String keyCity);
		
		
		//regexp
		@Query(value = "select *  from person_info p where "
				+ "p.name regexp :keyName "
				+ "or p.city regexp :keyCity " , nativeQuery = true)
		public List<PersonInfo> searchByNameOrCity2(
				@Param("keyName")String keyName,
				@Param("keyCity")String keyCity);
}

package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.TopupTransaction;

@Repository
public interface TopupRepository extends JpaRepository<TopupTransaction, Long>{
	
	@Query("select p from TopupTransaction p where p.userId = :userId")
	List<TopupTransaction> findAllByUserId(String userId); 
	
	@Query("select p from TopupTransaction p where p.userId = :userId and p.timestamp>= :start and p.timestamp <= :end")
	List<TopupTransaction> findByUserAndTime(String userId,Long start , Long end); 
}
package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.P2PTransaction;

@Repository
public interface P2PRepository extends JpaRepository<P2PTransaction, Long>{

	@Query("select p from P2PTransaction p where p.receiverId= :receiverId and p.timestamp >= :start and p.timestamp <= :end")
	public List<P2PTransaction> findByReceiverAndTime(String receiverId, Long start, Long end);
	
	@Query("select p from P2PTransaction p where p.senderId= :senderId and p.timestamp >= :start and p.timestamp <= :end")
	public List<P2PTransaction> findBySenderAndTime(String senderId, Long start, Long end);

	@Query("select p from P2PTransaction p where p.receiverId= :receiverId")
	public List<P2PTransaction> findByReceiverId(String receiverId);
	
	@Query("select p from P2PTransaction p where p.senderId= :senderId")
	public List<P2PTransaction> findBySenderId(String senderId);
	
	@Query("select p from P2PTransaction p where p.senderId= :userId or p.receiverId= :userId")
	public List<P2PTransaction> findByUser(String userId);
	
	
	
}

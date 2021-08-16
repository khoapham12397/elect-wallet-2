package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Present;

import java.util.List;

@Repository
public interface PresentRepository extends JpaRepository<Present,String>{
    @Query("select p from Present p where expired = 0 and startTime <= :expireTime")
	public List<Present> findExpiredPresent(Long expireTime);
}

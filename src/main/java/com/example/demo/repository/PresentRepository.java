package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Present;

@Repository
public interface PresentRepository extends JpaRepository<Present,String>{
	
}

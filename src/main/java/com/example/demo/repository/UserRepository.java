package com.example.demo.repository;

import java.util.Optional;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserProfile;

@Repository
public interface UserRepository extends JpaRepository<UserProfile, String>{
	
}

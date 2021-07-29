package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Authenticate;
@Repository
public interface AuthenticateRepository extends JpaRepository<Authenticate,String>{

}

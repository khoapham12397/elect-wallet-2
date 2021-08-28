package com.example.demo.repository;

import com.example.demo.entity.PaymentStatement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentStatementRepository extends JpaRepository<PaymentStatement, String> {

}

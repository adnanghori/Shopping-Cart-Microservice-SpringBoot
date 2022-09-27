package com.microservice.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.ecommerce.entity.TransactionDetails;

@Repository
public interface PaymentRepository extends JpaRepository<TransactionDetails, Long> {

	Optional<TransactionDetails> findByOrderID(Long orderID);
}

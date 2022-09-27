package com.microservice.ecommerce.entity;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transactions")
@Data @NoArgsConstructor @AllArgsConstructor 
public class TransactionDetails {

	@Id 
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private Long transactionID;
	private Long orderID;
	private String paymentMode;
	private String referenceNumber;
	private Instant paymentDate;
	private Long amount;
	
}

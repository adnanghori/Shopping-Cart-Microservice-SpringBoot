package com.microservice.ecommerce.service.adapter;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.microservice.ecommerce.entity.TransactionDetails;
import com.microservice.ecommerce.model.PaymentRequest;
import com.microservice.ecommerce.model.PaymentResponse;
import com.microservice.ecommerce.repository.PaymentRepository;
import com.microservice.ecommerce.service.PaymentService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@AllArgsConstructor
@Log4j2

public class PaymentServiceAdapter implements PaymentService {

	private final ModelMapper modelMapper;
	private final PaymentRepository paymentRepository;
	@Override
	public PaymentResponse makePayment(PaymentRequest paymentRequest) {
		log.info("Reading Payment Details");
		TransactionDetails paymentDetails = this.modelMapper.map(paymentRequest, TransactionDetails.class);
		paymentDetails.setPaymentDate(Instant.now());
		paymentDetails.setReferenceNumber(UUID.randomUUID().toString());
		log.info("Payment Done");
		return this.modelMapper.map(this.paymentRepository.save(paymentDetails), PaymentResponse.class);

	}
	@Override
	public PaymentResponse getPaymentDetailsByOrderID(Long orderID) {
		
		log.info("Getting Payment Details For The Order ID");
		 TransactionDetails transactionDetails = this.paymentRepository.findByOrderID(orderID).orElseThrow(() -> new RuntimeException("Order With ID :  "+ orderID+" Not Found"));
		 return this.modelMapper.map(transactionDetails, PaymentResponse.class);

	}

}

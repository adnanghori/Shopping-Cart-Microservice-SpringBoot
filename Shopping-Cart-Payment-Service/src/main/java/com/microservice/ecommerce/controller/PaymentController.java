package com.microservice.ecommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.ecommerce.model.PaymentRequest;
import com.microservice.ecommerce.model.PaymentResponse;
import com.microservice.ecommerce.service.PaymentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/payment")
@AllArgsConstructor 
public class PaymentController {

	private final PaymentService paymentService;
	
	@PostMapping("/do-payment")
	public ResponseEntity<String> doPayment(@RequestBody PaymentRequest paymentRequest){
		
		PaymentResponse paymentResponse = this.paymentService.makePayment(paymentRequest);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(
				 "Your Payment Of Amount  : " + paymentResponse.getAmount() +"\n"
				 + "With Reference Number : " + paymentResponse.getReferenceNumber() + "\n"
				 + "Order ID : " + paymentResponse.getOrderID() + "\n"
				 + "Mode Of Payment : " + paymentResponse.getPaymentMode() + "\n"
				 + "Date On : " + paymentResponse.getPaymentDate() + "\n"
				 + "Has Been Successfully Initiated" + "\n"
				);
		 
	}
	@GetMapping("/order/{orderID}")
	public ResponseEntity<PaymentResponse> getPaymentDetails(@PathVariable Long orderID){

		return new ResponseEntity<PaymentResponse>(this.paymentService.getPaymentDetailsByOrderID(orderID),HttpStatus.OK);
		
	}
}

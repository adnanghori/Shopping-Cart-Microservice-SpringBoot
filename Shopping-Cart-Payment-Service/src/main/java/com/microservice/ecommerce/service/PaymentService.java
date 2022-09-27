package com.microservice.ecommerce.service;

import com.microservice.ecommerce.model.PaymentRequest;
import com.microservice.ecommerce.model.PaymentResponse;

public interface PaymentService {

	public PaymentResponse makePayment(PaymentRequest paymentRequest);

	public PaymentResponse getPaymentDetailsByOrderID(Long orderID);

}

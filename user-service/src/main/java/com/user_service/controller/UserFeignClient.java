package com.user_service.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("PAYMENT-SERVICE")
public interface UserFeignClient {

	@GetMapping("/payment/options")
	public List<String> paymentOption();
}

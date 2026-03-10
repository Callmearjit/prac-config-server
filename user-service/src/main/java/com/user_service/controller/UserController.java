package com.user_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user_service.entity.UserInformation;
import com.user_service.service.UserService;

@RestController
public class UserController {
	//user is consumer and payment is producer 
	private UserFeignClient user;
	private UserService service;
	
	public UserController(UserService service,UserFeignClient user) {
		this.service=service;
		this.user=user;
		
	}
	@PostMapping("/create")
	public String create(@RequestBody UserInformation info) {
		return service.createUser(info);
		
	}
	
	@GetMapping("/{email}")
	public UserInformation findById(@PathVariable String email) {
		return service.findUserById(email);
	}
	
	@GetMapping("/pay")
	public List<String> getClient(){
		return user.paymentOption();
	}
	@GetMapping("/info")
	public String hi() {
		System.out.println("Hiiii");
		return" a";
	}
	

}

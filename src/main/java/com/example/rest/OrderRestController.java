package com.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.binding.Order;
import com.example.service.OrderService;

@RestController
public class OrderRestController {

	@Autowired
	private OrderService service;
	
	@PostMapping("/order")
	public String createOrder(@RequestBody Order order) {
	String Msg=	service.addMsg(order);
		return Msg;
	}
}
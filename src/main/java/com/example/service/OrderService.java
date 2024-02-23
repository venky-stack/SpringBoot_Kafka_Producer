package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.binding.Order;
import com.example.constant.AppConstants;

@Service
public class OrderService {

	@Autowired
	private KafkaTemplate<String,Order> kafkaTemplate;
	
	public String addMsg(Order order) {
		kafkaTemplate.send(AppConstants.TOPIC, order);
		
		return "Message Publisher to Kafka Topic";
	}
}
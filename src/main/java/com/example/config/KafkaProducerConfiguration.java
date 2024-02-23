package com.example.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.example.binding.Order;
import com.example.constant.AppConstants;

@Configuration
public class KafkaProducerConfiguration {

	@Bean
	public ProducerFactory<String,Order> producerFactory(){
		
		Map<String, Object> config= new HashMap<>();
		
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,AppConstants.HOST);
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		
		return new DefaultKafkaProducerFactory<>(config);	
	}
	
	@Bean
	public KafkaTemplate<String, Order> kafkaTemplate(){
		
		return new KafkaTemplate<>(producerFactory());
	}
}

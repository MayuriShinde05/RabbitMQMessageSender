package com.crif.contact.integrations.s1.rmq.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqSender implements AmqpSender {
	private RabbitTemplate rabbitTemplate;
	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqSender.class);

	@Autowired
	public RabbitMqSender(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	@Override
	public void sendMessage(Object message, String exchangeName) {
		sendMessage(message, exchangeName, message.getClass().getName());
	}

	@Override
	public void sendMessage(Object message, String exchange, String routingKey) {
		LOGGER.debug("Sending message to exchange {} with routing key {}: {}", exchange, routingKey, message);
	    rabbitTemplate.convertAndSend(exchange, routingKey, message);
	}
}

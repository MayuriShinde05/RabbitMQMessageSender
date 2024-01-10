package com.crif.contact.integrations.s1.rmq.service;

public interface AmqpSender {
	void sendMessage(Object message, String exchangeName);

	void sendMessage(Object message, String exchange, String routingKey);
}

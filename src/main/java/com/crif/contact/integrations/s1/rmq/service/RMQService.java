package com.crif.contact.integrations.s1.rmq.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.crif.contact.integrations.s1.event.PipelinedCOS1Event;
import com.crif.contact.integrations.s1.event.RMQMessage;

@Service
public class RMQService {

	private static Logger log = LoggerFactory.getLogger(RMQService.class);
	private final RabbitMqSender rabbitMqSender;

	public RMQService(RabbitMqSender rabbitMqSender) {
		this.rabbitMqSender = rabbitMqSender;
	}

	public void sendRabbitMqMessage(String exchange, String routingKey, String s1LoadId, String s1RequestId) {
		log.info("sendRabbitMqMessage() start");
		PipelinedCOS1Event message = new PipelinedCOS1Event();
		message.setS1LoadId(Long.parseLong(s1LoadId));
		message.setS1LoadRequestId(s1RequestId);

		rabbitMqSender.sendMessage(message, exchange);
		log.info("sendRabbitMqMessage() end");
	}
	public void sendRabbitMqMessage(String exchange, String routingKey, RMQMessage s1LoadRequest) {
		log.info("sendRabbitMqMessage() start");
		List<String> s1LoadIds = s1LoadRequest.getS1LoadId();
		String s1RequestId = s1LoadRequest.getS1RequestId();
		PipelinedCOS1Event message = new PipelinedCOS1Event();
		for (String s1LoadId : s1LoadIds) {
			message.setS1LoadId(Long.parseLong(s1LoadId));			
			message.setS1LoadRequestId(s1RequestId);
			rabbitMqSender.sendMessage(message, exchange);
		}
		log.info("sendRabbitMqMessage() end");
	}
}

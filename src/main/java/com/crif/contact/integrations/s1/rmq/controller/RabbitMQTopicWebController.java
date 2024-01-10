package com.crif.contact.integrations.s1.rmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crif.contact.integrations.s1.event.RMQMessage;
import com.crif.contact.integrations.s1.rmq.service.RMQService;

@RestController
@RequestMapping(value = "/rabbitmq/topic")
public class RabbitMQTopicWebController {

	@Autowired
	public RMQService rmqService;

	@GetMapping(value = "/producerMessage")
	public String producer(@RequestParam("exchangeName") String exchange, @RequestParam("routingKey") String routingKey,
			@RequestParam("s1LoadId") String s1LoadId, @RequestParam("s1RequestId") String s1RequestId) {

		rmqService.sendRabbitMqMessage(exchange, routingKey, s1LoadId, s1RequestId);

		return "Message sent to the RabbitMQ Topic Exchange Successfully";
	}
	
	@GetMapping(value = "/producerMessage/s1PipelinedCoEvent")
	public String producer(@RequestParam("exchangeName") String exchange, @RequestParam("routingKey") String routingKey,
			@RequestBody RMQMessage s1LoadRequest) {

		rmqService.sendRabbitMqMessage(exchange, routingKey, s1LoadRequest);

		return "Message sent to the RabbitMQ Topic Exchange Successfully";
	}

}

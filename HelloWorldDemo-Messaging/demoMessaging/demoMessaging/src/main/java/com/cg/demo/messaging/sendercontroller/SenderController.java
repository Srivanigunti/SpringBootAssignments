package com.cg.demo.messaging.sendercontroller;

import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.amqp.core.Queue;

@RestController
@RequestMapping("/message")

public class SenderController {

	@Autowired
	private RabbitMessagingTemplate template;

	@Bean
	public Queue queue() {
		return new Queue("helloworld", false);
	}

	@GetMapping("/{message}")
	public void message(@PathVariable String message) {

		template.convertAndSend("helloworld", message);

	}
}
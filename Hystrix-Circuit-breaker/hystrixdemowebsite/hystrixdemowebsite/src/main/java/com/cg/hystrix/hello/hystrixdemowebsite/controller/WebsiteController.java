package com.cg.hystrix.hello.hystrixdemowebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Controller
@EnableCircuitBreaker
public class WebsiteController {

	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@HystrixCommand(fallbackMethod = "reliable")
	@RequestMapping("/hello")
	public String hello(Model model) {
		ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:8989/hello", String.class);
		String hello = entity.getBody();
		model.addAttribute("hello", hello);
		return "hello";
	}

	public String reliable(Model model) {
		String hello = "Good Morning";
		model.addAttribute("hello", hello);
		return "hello";
	}
}
package com.cg.ureka.website.urekawebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@RefreshScope
@Controller
public class WebsiteController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/message")
	public String display(Model model) {
//		String entity = restTemplate.getForObject("http://eurekaClient/hello", String.class);
		String hello = "HelloWorld";
		model.addAttribute("hello", hello);
		return "index";
		
	}
}

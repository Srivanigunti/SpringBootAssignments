package com.cg.hystrix.hello.hystrixdemohello.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class DemoController {
	
		@GetMapping
		public ResponseEntity<String> hello(){
			return new ResponseEntity<String>("HELLO WORLD!!!",HttpStatus.OK);
		}
}
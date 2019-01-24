package com.cg.ureka.urekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class UrekaserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrekaserviceApplication.class, args);
	}

}
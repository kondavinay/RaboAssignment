package com.cts.assignment.RaboCustomerDetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.cts.assignment.RaboCustomerDetails")
public class RaboCustomerDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RaboCustomerDetailsApplication.class, args);
	}

}


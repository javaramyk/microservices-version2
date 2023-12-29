package com.example.microservices.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	@GetMapping("/sample-api")
	//@Retry(name="sample-api",fallbackMethod="hardCodeDefault")
	//@CircuitBreaker(name="sample-api",fallbackMethod="hardCodeDefault")
	//@RateLimiter(name="sample-api")
	@Bulkhead(name="sample-api")
	public String getSampleRequest() {
		logger.info("SampleAPI call while CircuitBreaker demo");
		return "sample-api";
		/*ResponseEntity<String> response = new RestTemplate().getForEntity("http://localhost:8080/class",String.class);		
		return response.getBody();*/
	}
	
	public String hardCodeDefault(Exception ex) {
		return "Error has been recorded";
	}
}

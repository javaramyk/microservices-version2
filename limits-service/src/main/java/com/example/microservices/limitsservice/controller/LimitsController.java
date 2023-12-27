package com.example.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.limitsservice.bean.LimitConfiguration;
import com.example.microservices.limitsservice.bean.Limits;

@RestController
public class LimitsController {

	@Autowired
	private LimitConfiguration limitConfig;
	
	@GetMapping("/limits")
	public Limits retreivalLimitConfiguration() {
		return new Limits(limitConfig.getMinimum(),limitConfig.getMaximum());
	}
}

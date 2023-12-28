package com.example.microservices.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.microservices.currencyconversionservice.bean.CurrencyConversion;

@RestController
public class CurrencyConversionController {

	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion retrieveCalculatedConversionValue(@PathVariable String from,@PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		HashMap<String,String> uriVariables = new HashMap<String,String>();
		uriVariables.put("from",from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversion> response = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}"
				,CurrencyConversion.class,uriVariables);
		CurrencyConversion currencyConversion = response.getBody();
		return new CurrencyConversion(currencyConversion.getId(), 
				from, to, quantity, 
				currencyConversion.getConversionMultiple(), 
				quantity.multiply(currencyConversion.getConversionMultiple()), 
				currencyConversion.getEnvironment()+ " " + "rest template");	
	}
}

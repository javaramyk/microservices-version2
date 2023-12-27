package com.example.microservices.limitsservice.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
//Registered as bean
@ConfigurationProperties("limit-service")
//to get the min and max values set from application.properties
public class LimitConfiguration {
	
	private int minimum;
	private int maximum;
	public LimitConfiguration(int minimum, int maximum) {
		super();
		this.maximum = maximum;
		this.minimum = minimum;
	}
	public LimitConfiguration() {
	}
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	public int getMinimum() {
		return minimum;
	}
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	

}

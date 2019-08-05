package com.springbootlambda.model;

public class GreetUser {
	private String greeting;
	
	public GreetUser() {
		super();
	}
	
	public GreetUser(String greeting) {
		super();
		this.greeting = greeting;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	
	
}

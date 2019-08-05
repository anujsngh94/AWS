package com.springbootlambda.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springbootlambda.exception.ValidationException;
import com.springbootlambda.model.GreetUser;
import com.springbootlambda.model.Username;


@RestController
public class BasicController {
	
	@RequestMapping(value="/user-name", method = RequestMethod.POST)
	public GreetUser greetingUser(@RequestBody Username username) throws ValidationException{
		System.out.println("input username : "+ username.getName());
		if(username.getName() == null || username.getName().isEmpty()){
			System.out.println("throwing validation exception.");
			throw new ValidationException("Validation Exception. Username is Empty or NULL");
		}
		return new GreetUser("Hello "+ username.getName());
	}
}

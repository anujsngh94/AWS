package com.springbootlambda.model;

import java.io.Serializable;

public class Username {
	
	private String name;
	
	public Username() {
		super();
	}

	public Username(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

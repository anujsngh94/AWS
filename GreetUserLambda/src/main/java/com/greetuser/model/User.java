package com.greetuser.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class User {

	private String name;
	 
    public User(String json) {
        Gson gson = new Gson();
        User request = gson.fromJson(json, User.class);
        this.name = request.getName();
    }
 
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
}

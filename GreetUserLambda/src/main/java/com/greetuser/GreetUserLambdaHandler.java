package com.greetuser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.xml.bind.ValidationException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.greetuser.model.User;

public class GreetUserLambdaHandler implements RequestStreamHandler{

	@Override
	public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
		System.out.println("Inside handle Request method.");
		JSONParser jsonParser = new JSONParser();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		JSONObject responseJson = new JSONObject();
		JSONObject responseBody = new JSONObject();
		JSONObject headerJson = new JSONObject();
		
		headerJson.put("Access-Control-Allow-Origin", "*");
		try {
			JSONObject event = (JSONObject) jsonParser.parse(bufferedReader);
			System.out.println("Event Json: "+  event.toJSONString());
			if (event.get("body") != null) {
	            User user = new User((String) event.get("body"));
	            
	            if(user.getName() == null || user.getName().isEmpty()){
	            	throw new ValidationException("Validation Error. \"name\" is Empty or NULL.");
	            	/*responseBody.put("message", "");
	            	responseJson.put("statusCode", 400);*/
	            }else{
	            	responseBody.put("message", "Hello " + user.getName());
		            responseJson.put("statusCode", 200);
	            }
			}
	        
		} catch (ParseException e) {
			
			responseBody.put("message", "Request Body Parsing Exception");
			responseBody.put("exception", e.getMessage());
			responseJson.put("statusCode", 400);
		}
		catch(ValidationException e){
			responseBody.put("message", "BAD_REQUEST");
			responseBody.put("exception", e.getMessage());
			responseJson.put("statusCode", 400);
		}
		
		responseJson.put("headers", headerJson);
		responseJson.put("body", responseBody.toString());
		
		System.out.println("Reponse JSON: "+ responseJson.toJSONString());
		OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
	    writer.write(responseJson.toString());
	    writer.close();
		
	}

}

package com.springbootlambda.exception;

import org.json.simple.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler({ ValidationException.class })
    public ResponseEntity<Object> handleBadRequest(final ValidationException ex, final WebRequest request) {
//        final String bodyOfResponse = "This should be application specific";
        System.out.println("handing validation exception: ");
        JSONObject responseJson = new JSONObject();
        /*
         * 	"status": 400,
    		"error": "Bad Request",
    		"message": "Validation Exception. Username is Empty or NULL",
         */
        responseJson.put("status", HttpStatus.BAD_REQUEST.value());
        responseJson.put("error", HttpStatus.BAD_REQUEST);
        responseJson.put("message", ex.getMessage());
        
        return handleExceptionInternal(ex, responseJson, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}

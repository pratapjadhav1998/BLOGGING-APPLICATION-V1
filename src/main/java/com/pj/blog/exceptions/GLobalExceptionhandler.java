package com.pj.blog.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pj.blog.dtos.ApiResponse;
//use to handle exception gloabally
@RestControllerAdvice
public class GLobalExceptionhandler {
	@ExceptionHandler(ResourceNotfoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotfoundException ex)
	{
		String message=ex.getMessage();
		ApiResponse apiresp= new ApiResponse(message,false);
		return new ResponseEntity<ApiResponse>(apiresp,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String , String>> MethodArgNotValidException(MethodArgumentNotValidException ex)
	{
		Map<String , String> resp=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName=((FieldError)error).getField();
			String message=error.getDefaultMessage();
			resp.put(fieldName, message);
		});
		
		return new ResponseEntity<Map<String , String>>(resp,HttpStatus.BAD_REQUEST);
		
	}

}

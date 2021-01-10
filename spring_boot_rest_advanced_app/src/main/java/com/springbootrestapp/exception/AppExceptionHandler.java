package com.springbootrestapp.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springbootrestapp.entities.ExceptionResponse;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllException(Exception ex, WebRequest request) throws Exception {
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), request.getDescription(false), new Date());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), request.getDescription(false), new Date());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), request.getDescription(false), new Date());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST); 
	}
}

package org.gestion.web.controller;

import java.sql.SQLException;

import org.gestion.exceptions.FunctionalException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AbstractRestController {
	
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseEntity<Object> handle (Exception exception){
		
		if (exception instanceof FunctionalException){
			String body = ((FunctionalException) exception).jsonResponse();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			return new ResponseEntity<Object>(body, headers, HttpStatus.CONFLICT);
		}
		if (exception instanceof SQLException){
			String body = ((SQLException) exception).getSQLState();
			HttpHeaders headers = new HttpHeaders();
			//headers.setContentType(MediaType.APPLICATION_JSON);
			return new ResponseEntity<Object>(body, headers, HttpStatus.PRECONDITION_FAILED);
		}
		else return new ResponseEntity<Object>("There is an uncatched error... Maybe your app is not well developped ?", HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

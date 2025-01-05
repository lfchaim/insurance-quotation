package com.lfchaim.insurance.quotation.infrastructure.adapters.input.rest.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Responder {

	private HttpStatus status;
	private Object result;
	private ErrorInfo errorInfo;
	
	public ResponseEntity<?> getResponse(){
		if( status != null && result != null ) {
			return new ResponseEntity<>(result, status);
		} else if ( errorInfo != null ) {
			return new ResponseEntity<>(errorInfo, errorInfo.getError().getStatus());
		} else {
			return new ResponseEntity<>("Cannot return response", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
}

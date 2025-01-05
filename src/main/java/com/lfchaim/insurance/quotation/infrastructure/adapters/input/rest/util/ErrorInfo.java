package com.lfchaim.insurance.quotation.infrastructure.adapters.input.rest.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorInfo {

	private ErrorCode error;
	private String message;
	private String extraInfo;
	
}

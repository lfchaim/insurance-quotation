package com.lfchaim.insurance.quotation.domain.exception;

public class InsuranceQuotationNotFoundException extends RuntimeException{
    
	private static final long serialVersionUID = 1L;

	public InsuranceQuotationNotFoundException(String msg){
        super(msg);
    }
}

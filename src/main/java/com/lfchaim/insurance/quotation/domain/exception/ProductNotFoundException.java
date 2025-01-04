package com.lfchaim.insurance.quotation.domain.exception;

public class ProductNotFoundException extends RuntimeException{
    
    public ProductNotFoundException(String msg){
        super(msg);
    }
}

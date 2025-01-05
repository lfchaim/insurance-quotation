package com.lfchaim.insurance.quotation.infrastructure.adapters.output.persistence;

import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lfchaim.insurance.quotation.application.ports.output.ProductOutputPort;
import com.lfchaim.insurance.quotation.domain.model.Product;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductPersistenceAdapter implements ProductOutputPort {

    @Override
    public Optional<Product> getProductById(String id) {
    	Product product = null;
    	try {
	    	RestAssured.baseURI = "http://localhost:1080";
	    	RequestSpecification httpRequest = RestAssured.given();
	    	Response response = httpRequest.get("/products");
	
	    	ResponseBody body = response.getBody();
	    	
	    	String sBody = body.asString();
	    	
	    	ObjectMapper objectMapper = new ObjectMapper();
	    	product = objectMapper.readValue(sBody, Product.class);
    	}catch( JsonProcessingException e ) {
    		e.printStackTrace();
    	}
        return Optional.of(product);
    }
    
}

package com.lfchaim.insurance.quotation.infrastructure.adapters.output.persistence;

import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lfchaim.insurance.quotation.application.ports.output.InsurancePolicyOutputPort;
import com.lfchaim.insurance.quotation.domain.model.InsurancePolicy;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InsurancePolicyPersistenceAdapter implements InsurancePolicyOutputPort {

    @Override
    public Optional<InsurancePolicy> getById(String product_id, String offer_id) {
    	InsurancePolicy insurancePolicy = null;
    	try {
	    	RestAssured.baseURI = "http://localhost:1080";
	    	RequestSpecification httpRequest = RestAssured.given();
	    	Response response = httpRequest.get("/insurance-policy");
	
	    	ResponseBody body = response.getBody();
	    	
	    	String sBody = body.asString();
	    	
	    	ObjectMapper objectMapper = new ObjectMapper();
	    	insurancePolicy = objectMapper.readValue(sBody, InsurancePolicy.class);
    	}catch( JsonProcessingException e ) {
    		e.printStackTrace();
    	}
        return Optional.of(insurancePolicy);
    }
    
}

package com.lfchaim.insurance.quotation.domain.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;

import com.lfchaim.insurance.quotation.application.ports.input.CreateInsuranceQuotationUseCase;
import com.lfchaim.insurance.quotation.application.ports.input.GetInsuranceQuotationUseCase;
import com.lfchaim.insurance.quotation.application.ports.output.InsurancePolicyOutputPort;
import com.lfchaim.insurance.quotation.application.ports.output.InsuranceQuotationOutputPort;
import com.lfchaim.insurance.quotation.application.ports.output.ProductOutputPort;
import com.lfchaim.insurance.quotation.domain.exception.InsuranceQuotationNotFoundException;
import com.lfchaim.insurance.quotation.domain.model.InsurancePolicy;
import com.lfchaim.insurance.quotation.domain.model.InsuranceQuotation;
import com.lfchaim.insurance.quotation.domain.model.Product;
import com.lfchaim.insurance.quotation.infrastructure.adapters.input.rest.util.ErrorCode;
import com.lfchaim.insurance.quotation.infrastructure.adapters.input.rest.util.ErrorInfo;
import com.lfchaim.insurance.quotation.infrastructure.adapters.input.rest.util.Responder;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InsuranceQuotationService implements CreateInsuranceQuotationUseCase, GetInsuranceQuotationUseCase{

    private final InsuranceQuotationOutputPort insuranceQuotationOutputPort;
    
    private final ProductOutputPort productOutputPort;
    
    private final InsurancePolicyOutputPort insurancePolicyOutputPort;
    
    @Override
    public InsuranceQuotation getById(String id) {
        return insuranceQuotationOutputPort.getById(id)
        		.orElseThrow(() -> new InsuranceQuotationNotFoundException("Insurance Quotation not found ID: " + id));
    }

    @Override
    public Responder create(InsuranceQuotation model) {
    	Responder responder = null;
    	Optional<Product> product = productOutputPort.getProductById(model.getProduct_id());
    	if( product == null != !product.get().getId().equals(model.getProduct_id()) ) {
    		ErrorInfo errorInfo = new ErrorInfo(ErrorCode.UNPROCESSABLE_ENTITY,"Product not found",null);
    		responder = new Responder(null,null,errorInfo);
    		return responder;
    	}
    	Optional<InsurancePolicy> insurancePolicy = insurancePolicyOutputPort.getById(model.getProduct_id(), model.getOffer_id());
    	if( insurancePolicy == null || insurancePolicy.get().getId() < 1 || !insurancePolicy.get().getOffer_id().equals(model.getOffer_id()) ) {
    		ErrorInfo errorInfo = new ErrorInfo(ErrorCode.UNPROCESSABLE_ENTITY,"Insurance Policy not found",null);
    		responder = new Responder(null,null,errorInfo);
    		return responder;
    	}
    	InsuranceQuotation insuranceQuotation = insuranceQuotationOutputPort.save(model);
    	if( insuranceQuotation != null ) {
    		responder = new Responder(HttpStatus.CREATED, insuranceQuotation, null); 
    	} else {
    		ErrorInfo errorInfo = new ErrorInfo(ErrorCode.UNPROCESSABLE_ENTITY,"Cannot create Insurance Quotation",null);
    		responder = new Responder(null,null,errorInfo);
    	}
        return responder;
    }
    
}

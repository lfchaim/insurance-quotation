package com.lfchaim.insurance.quotation.domain.service;

import com.lfchaim.insurance.quotation.application.ports.input.CreateInsuranceQuotationUseCase;
import com.lfchaim.insurance.quotation.application.ports.input.GetInsuranceQuotationUseCase;
import com.lfchaim.insurance.quotation.application.ports.output.InsuranceQuotationOutputPort;
import com.lfchaim.insurance.quotation.domain.exception.InsuranceQuotationNotFoundException;
import com.lfchaim.insurance.quotation.domain.model.InsuranceQuotation;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InsuranceQuotationService implements CreateInsuranceQuotationUseCase, GetInsuranceQuotationUseCase{

    private final InsuranceQuotationOutputPort insuranceQuotationOutputPort;
    
    @Override
    public InsuranceQuotation getById(String id) {
        System.out.println("Retornando InsuranceQuotationo por ID");
        return insuranceQuotationOutputPort.getById(id)
        		.orElseThrow(() -> new InsuranceQuotationNotFoundException("Insurance Quotation not found ID: " + id));
    }

    @Override
    public InsuranceQuotation create(InsuranceQuotation model) {
        System.out.println("Creating InsuranceQuotation");
        return insuranceQuotationOutputPort.save(model);
    }
    
}

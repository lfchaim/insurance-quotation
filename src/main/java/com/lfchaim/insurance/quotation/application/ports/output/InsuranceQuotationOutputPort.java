package com.lfchaim.insurance.quotation.application.ports.output;

import java.util.Optional;

import com.lfchaim.insurance.quotation.domain.model.InsuranceQuotation;

public interface InsuranceQuotationOutputPort {
    
    InsuranceQuotation save(InsuranceQuotation product);
    
    Optional<InsuranceQuotation> getById(String id);
    
}

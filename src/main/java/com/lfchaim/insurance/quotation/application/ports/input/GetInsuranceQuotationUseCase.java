package com.lfchaim.insurance.quotation.application.ports.input;

import com.lfchaim.insurance.quotation.domain.model.InsuranceQuotation;

public interface GetInsuranceQuotationUseCase {
   
    InsuranceQuotation getById(String id);
    
}

package com.lfchaim.insurance.quotation.application.ports.input;

import com.lfchaim.insurance.quotation.domain.model.InsuranceQuotation;
import com.lfchaim.insurance.quotation.infrastructure.adapters.input.rest.util.Responder;

public interface CreateInsuranceQuotationUseCase {
   
    //InsuranceQuotation create(InsuranceQuotation model);
	Responder create(InsuranceQuotation model);
    
}

package com.lfchaim.insurance.quotation.application.ports.output;

import java.util.Optional;

import com.lfchaim.insurance.quotation.domain.model.InsurancePolicy;

public interface InsurancePolicyOutputPort {
    
    Optional<InsurancePolicy> getById(String product_id, String offer_id);
    
}

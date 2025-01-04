package com.lfchaim.insurance.quotation.infrastructure.adapters.output.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lfchaim.insurance.quotation.infrastructure.adapters.output.persistence.entity.InsuranceQuotationEntity;

public interface InsuranceQuotationRepository extends MongoRepository<InsuranceQuotationEntity, String>{
    
}

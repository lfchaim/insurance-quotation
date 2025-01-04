package com.lfchaim.insurance.quotation.infrastructure.adapters.output.persistence;

import java.util.Optional;

import com.lfchaim.insurance.quotation.application.ports.output.InsuranceQuotationOutputPort;
import com.lfchaim.insurance.quotation.domain.model.InsuranceQuotation;
import com.lfchaim.insurance.quotation.infrastructure.adapters.output.persistence.entity.InsuranceQuotationEntity;
import com.lfchaim.insurance.quotation.infrastructure.adapters.output.persistence.mapper.InsuranceQuotationMapper;
import com.lfchaim.insurance.quotation.infrastructure.adapters.output.persistence.repository.InsuranceQuotationRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InsuranceQuotationPersistenceAdapter implements InsuranceQuotationOutputPort {

    private final InsuranceQuotationRepository insuranceQuotationRepository;

    private final InsuranceQuotationMapper mapper;
    
    @Override
    public InsuranceQuotation save(InsuranceQuotation model) {
        InsuranceQuotationEntity modelEntity = mapper.toEntity(model);
        insuranceQuotationRepository.save(modelEntity);
        return mapper.toModel(modelEntity);
    }

    @Override
    public Optional<InsuranceQuotation> getById(String id) {
        Optional<InsuranceQuotationEntity> modelEntity = insuranceQuotationRepository.findById(id);

        if(modelEntity.isEmpty()) {
            return Optional.empty();
        }
        
        InsuranceQuotation model = mapper.toModel(modelEntity.get());
        return Optional.of(model);
    }
    
}

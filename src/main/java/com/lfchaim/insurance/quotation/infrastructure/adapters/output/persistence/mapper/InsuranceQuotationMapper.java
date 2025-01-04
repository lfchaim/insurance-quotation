package com.lfchaim.insurance.quotation.infrastructure.adapters.output.persistence.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.lfchaim.insurance.quotation.domain.model.InsuranceQuotation;
import com.lfchaim.insurance.quotation.infrastructure.adapters.output.persistence.entity.InsuranceQuotationEntity;

public class InsuranceQuotationMapper {

    @Autowired
    private ModelMapper mapper;

    public InsuranceQuotation toModel(InsuranceQuotationEntity entity){
        return mapper.map(entity, InsuranceQuotation.class);
    }
    
    public InsuranceQuotationEntity toEntity(InsuranceQuotation model){
        return mapper.map(model, InsuranceQuotationEntity.class);
    }

}

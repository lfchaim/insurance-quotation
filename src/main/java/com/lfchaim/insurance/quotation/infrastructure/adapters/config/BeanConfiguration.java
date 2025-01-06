package com.lfchaim.insurance.quotation.infrastructure.adapters.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lfchaim.insurance.quotation.domain.service.InsuranceQuotationService;
import com.lfchaim.insurance.quotation.domain.service.ProductService;
import com.lfchaim.insurance.quotation.infrastructure.adapters.input.rest.util.Responder;
import com.lfchaim.insurance.quotation.infrastructure.adapters.output.persistence.InsurancePolicyPersistenceAdapter;
import com.lfchaim.insurance.quotation.infrastructure.adapters.output.persistence.InsuranceQuotationPersistenceAdapter;
import com.lfchaim.insurance.quotation.infrastructure.adapters.output.persistence.ProductPersistenceAdapter;
import com.lfchaim.insurance.quotation.infrastructure.adapters.output.persistence.mapper.InsuranceQuotationMapper;
import com.lfchaim.insurance.quotation.infrastructure.adapters.output.persistence.repository.InsuranceQuotationRepository;

@Configuration
public class BeanConfiguration {
    
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public ProductPersistenceAdapter productPersistenceAdapter() {
        return new ProductPersistenceAdapter();
    }

    @Bean
    public InsurancePolicyPersistenceAdapter insurancePolicyPersistenceAdapter() {
        return new InsurancePolicyPersistenceAdapter();
    }
    
    @Bean
    public ProductService productService(ProductPersistenceAdapter productPersistenceAdapter) {
        return new ProductService(productPersistenceAdapter);
    }

    @Bean
    public InsuranceQuotationMapper insuranceQuotationMapper(){
        return new InsuranceQuotationMapper();
    }

    @Bean
    public InsuranceQuotationPersistenceAdapter insuranceQuotationPersistenceAdapter(InsuranceQuotationRepository insuranceQuotationRepository, InsuranceQuotationMapper insuranceQuotationMapper) {
        return new InsuranceQuotationPersistenceAdapter(insuranceQuotationRepository, insuranceQuotationMapper);
    }

    @Bean
    public InsuranceQuotationService insuranceQuotationService(InsuranceQuotationPersistenceAdapter insuranceQuotationPersistenceAdapter, ProductPersistenceAdapter productPersistenceAdapter, InsurancePolicyPersistenceAdapter insurancePolicyPersistenceAdapter) {
        return new InsuranceQuotationService(insuranceQuotationPersistenceAdapter, productPersistenceAdapter, insurancePolicyPersistenceAdapter);
    }

    @Bean
    public Responder responder(){
        return new Responder();
    }

}

package com.lfchaim.insurance.quotation.infrastructure.adapters.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lfchaim.insurance.quotation.domain.service.InsuranceQuotationService;
import com.lfchaim.insurance.quotation.domain.service.ProductService;
import com.lfchaim.insurance.quotation.infrastructure.adapters.output.persistence.InsuranceQuotationPersistenceAdapter;
import com.lfchaim.insurance.quotation.infrastructure.adapters.output.persistence.ProductPersistenceAdapter;
import com.lfchaim.insurance.quotation.infrastructure.adapters.output.persistence.mapper.InsuranceQuotationMapper;
import com.lfchaim.insurance.quotation.infrastructure.adapters.output.persistence.mapper.ProductMapper;
import com.lfchaim.insurance.quotation.infrastructure.adapters.output.persistence.repository.InsuranceQuotationRepository;
import com.lfchaim.insurance.quotation.infrastructure.adapters.output.persistence.repository.ProductRepository;

/**
 * Configuracion BEANS
 */
@Configuration
public class BeanConfiguration {
    
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public ProductMapper productMapper(){
        return new ProductMapper();
    }
    
    @Bean
    public ProductPersistenceAdapter productPersistenceAdapter(ProductRepository productRepository, ProductMapper productMapper) {
        return new ProductPersistenceAdapter(productRepository, productMapper);
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
    public InsuranceQuotationService insuranceQuotationService(InsuranceQuotationPersistenceAdapter insuranceQuotationPersistenceAdapter) {
        return new InsuranceQuotationService(insuranceQuotationPersistenceAdapter);
    }

}

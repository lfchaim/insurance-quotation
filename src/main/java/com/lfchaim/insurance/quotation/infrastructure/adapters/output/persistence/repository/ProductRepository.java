package com.lfchaim.insurance.quotation.infrastructure.adapters.output.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lfchaim.insurance.quotation.infrastructure.adapters.output.persistence.entity.ProductEntity;

public interface ProductRepository extends MongoRepository<ProductEntity, String>{
    
}

package com.lfchaim.insurance.quotation.infrastructure.adapters.output.persistence.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.lfchaim.insurance.quotation.domain.model.Product;
import com.lfchaim.insurance.quotation.infrastructure.adapters.output.persistence.entity.ProductEntity;

public class ProductMapper {

    @Autowired
    private ModelMapper mapper;

    public Product toProduct(ProductEntity entity){
        return mapper.map(entity, Product.class);
    }
    
    public ProductEntity toEntity(Product product){
        return mapper.map(product, ProductEntity.class);
    }

}

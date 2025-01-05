package com.lfchaim.insurance.quotation.domain.service;

import com.lfchaim.insurance.quotation.application.ports.input.GetProductUseCase;
import com.lfchaim.insurance.quotation.application.ports.output.ProductOutputPort;
import com.lfchaim.insurance.quotation.domain.exception.ProductNotFoundException;
import com.lfchaim.insurance.quotation.domain.model.Product;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductService implements GetProductUseCase{

    private final ProductOutputPort productOutputPort;
    
    @Override
    public Product getProductById(String id) {
        return productOutputPort.getProductById(id)
        		.orElseThrow(() -> new ProductNotFoundException("Product not found ID: " + id));
    }

}

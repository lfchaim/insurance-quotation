package com.lfchaim.insurance.quotation.application.ports.output;

import java.util.Optional;

import com.lfchaim.insurance.quotation.domain.model.Product;

public interface ProductOutputPort {
    
    Product saveProduct(Product product);
    
    Optional<Product> getProductById(String id);
    
}

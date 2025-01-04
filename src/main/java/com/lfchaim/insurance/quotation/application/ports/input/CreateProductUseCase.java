package com.lfchaim.insurance.quotation.application.ports.input;

import com.lfchaim.insurance.quotation.domain.model.Product;

public interface CreateProductUseCase {
   
    Product createProduct(Product product);
    
}

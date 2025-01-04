package com.lfchaim.insurance.quotation.application.ports.input;

import com.lfchaim.insurance.quotation.domain.model.Product;

public interface GetProductUseCase {
   
    Product getProductById(String id);
    
}

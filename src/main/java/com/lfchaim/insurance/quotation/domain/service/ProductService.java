package com.lfchaim.insurance.quotation.domain.service;

import com.lfchaim.insurance.quotation.application.ports.input.CreateProductUseCase;
import com.lfchaim.insurance.quotation.application.ports.input.GetProductUseCase;
import com.lfchaim.insurance.quotation.application.ports.output.ProductOutputPort;
import com.lfchaim.insurance.quotation.domain.exception.ProductNotFoundException;
import com.lfchaim.insurance.quotation.domain.model.Product;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductService implements CreateProductUseCase, GetProductUseCase{

    private final ProductOutputPort productOutputPort;
    
    @Override
    public Product getProductById(String id) {
        System.out.println("Retornando Producto por ID");
        return productOutputPort.getProductById(id)
                                .orElseThrow(() -> new ProductNotFoundException("No se encontro el producto con ID: " + id));
    }

    @Override
    public Product createProduct(Product product) {
        System.out.println("Creando Producto");
        return productOutputPort.saveProduct(product);
    }
    
}

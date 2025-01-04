package com.lfchaim.insurance.quotation.infrastructure.adapters.input;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lfchaim.insurance.quotation.application.ports.input.CreateProductUseCase;
import com.lfchaim.insurance.quotation.application.ports.input.GetProductUseCase;
import com.lfchaim.insurance.quotation.domain.model.Product;
import com.lfchaim.insurance.quotation.infrastructure.adapters.input.rest.data.request.ProductRequest;
import com.lfchaim.insurance.quotation.infrastructure.adapters.input.rest.data.response.ProductResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class ProductRestAdapter {
    
    private final CreateProductUseCase createProductUseCase;

    private final GetProductUseCase getProductUseCase;

    private final ModelMapper mapper;

    @PostMapping(value = "/products")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productToCreate){
        // Request to domain
        Product product = mapper.map(productToCreate, Product.class);
        product = createProductUseCase.createProduct(product);
        // Domain to response
        return new ResponseEntity<>(mapper.map(product, ProductResponse.class), HttpStatus.CREATED);
    }

    @GetMapping(value = "/products/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable String id){
        Product product = getProductUseCase.getProductById(id);
        // Domain to response
        return new ResponseEntity<>(mapper.map(product, ProductResponse.class), HttpStatus.OK);
    }
    
}

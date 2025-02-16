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

import com.lfchaim.insurance.quotation.application.ports.input.CreateInsuranceQuotationUseCase;
import com.lfchaim.insurance.quotation.application.ports.input.GetInsuranceQuotationUseCase;
import com.lfchaim.insurance.quotation.domain.model.InsuranceQuotation;
import com.lfchaim.insurance.quotation.infrastructure.adapters.input.rest.data.request.InsuranceQuotationRequest;
import com.lfchaim.insurance.quotation.infrastructure.adapters.input.rest.data.response.InsuranceQuotationResponse;
import com.lfchaim.insurance.quotation.infrastructure.adapters.input.rest.util.Responder;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class InsuranceQuotationRestAdapter {
    
    private final CreateInsuranceQuotationUseCase createInsuranceQuotationUseCase;

    private final GetInsuranceQuotationUseCase getInsuranceQuotationUseCase;

    private final ModelMapper mapper;
    
    @PostMapping(value = "/insurance-quotations")
    public ResponseEntity<InsuranceQuotationResponse> createInsuranceQuotation(@RequestBody InsuranceQuotationRequest insuranceQuotationToCreate){
        Responder responder = null;
        InsuranceQuotation insuranceQuotation = mapper.map(insuranceQuotationToCreate, InsuranceQuotation.class);
        //insuranceQuotation = createInsuranceQuotationUseCase.create(insuranceQuotation);
        //return new ResponseEntity<>(mapper.map(insuranceQuotation, InsuranceQuotationResponse.class), HttpStatus.CREATED);
        responder = createInsuranceQuotationUseCase.create(insuranceQuotation);
        return (ResponseEntity<InsuranceQuotationResponse>) responder.getResponse();
    }

    @GetMapping(value = "/insurance-quotations/{id}")
    public ResponseEntity<InsuranceQuotationResponse> getInsuranceQuotation(@PathVariable String id){
        InsuranceQuotation insuranceQuotation = getInsuranceQuotationUseCase.getById(id);
        return new ResponseEntity<>(mapper.map(insuranceQuotation, InsuranceQuotationResponse.class), HttpStatus.OK);
    }
    
}

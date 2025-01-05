package com.lfchaim.insurance.quotation.test.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lfchaim.insurance.quotation.domain.model.InsuranceQuotation;
import com.lfchaim.insurance.quotation.domain.service.InsuranceQuotationService;
import com.lfchaim.insurance.quotation.infrastructure.adapters.input.rest.util.Responder;
import com.lfchaim.insurance.quotation.infrastructure.adapters.output.persistence.repository.InsuranceQuotationRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class InvoiceQuotationTest {

	@Mock
	private InsuranceQuotationRepository insuranceQuotationRepository;

	@InjectMocks
	@Autowired
    private InsuranceQuotationService useCaseCreate;

    @Test
    void testCreateInsuranceQuotation() {
    	InsuranceQuotation insuranceQuotation = new InsuranceQuotation();
    	insuranceQuotation.setProduct_id("prod-1");
    	insuranceQuotation.setOffer_id("offer-1");

    	Responder responder = useCaseCreate.create(insuranceQuotation);
        InsuranceQuotation created = (InsuranceQuotation)responder.getResult();

        assertEquals("prod-1", created.getProduct_id());
    }
    
}

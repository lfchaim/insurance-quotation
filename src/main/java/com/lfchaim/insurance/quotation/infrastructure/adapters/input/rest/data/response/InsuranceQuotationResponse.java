package com.lfchaim.insurance.quotation.infrastructure.adapters.input.rest.data.response;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceQuotationResponse {
    
	private String id;
    private String product_id;
    private String offer_id;
    private String category;
    private Double total_monthly_premium_amount;
    private Double total_coverage_amount;
    private Map<String, Double> coverages;
    private List<String> assistances;
    private CustomerResponse customer;
    
}

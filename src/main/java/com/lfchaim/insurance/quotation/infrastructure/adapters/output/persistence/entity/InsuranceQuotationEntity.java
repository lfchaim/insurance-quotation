package com.lfchaim.insurance.quotation.infrastructure.adapters.output.persistence.entity;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection="insurance-quotations")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceQuotationEntity {

	private String id;
    private String product_id;
    private String offer_id;
    private String category;
    private Double total_monthly_premium_amount;
    private Double total_coverage_amount;
    private Map<String, Double> coverages;
    private List<String> assistances;
    private CustomerEntity customer;
}

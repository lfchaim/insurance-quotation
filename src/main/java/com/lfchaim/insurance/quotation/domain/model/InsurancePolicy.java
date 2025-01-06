package com.lfchaim.insurance.quotation.domain.model;

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
public class InsurancePolicy {

	private Integer id;
	private Integer insurance_policy_id;
	private String product_id;
	private String offer_id;
	private String category;
	private String created_at;
	private String updated_at;
	private Float total_monthly_premium_amount;
	private Float total_coverage_amount;
	private Map<String, Double> coverages;
	private List<String> assistances;
    private Customer customer;

}

package com.lfchaim.insurance.quotation.infrastructure.adapters.input.rest.data.request;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotEmpty;

import com.lfchaim.insurance.quotation.infrastructure.adapters.output.persistence.entity.CustomerEntity;

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
public class CustomerRequest {
    
	private String document_number;
    private String name;
    private String type;
    private String gender;
    private String date_of_birth;
    private String email;
    private Long phone_number;
    
}

